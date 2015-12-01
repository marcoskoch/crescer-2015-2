package br.com.cwi.crescer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ClienteDAO;
import br.com.cwi.crescer.dao.PedidoDAO;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.dto.PedidoDTO;
import br.com.cwi.crescer.dto.PedidoListaDTO;

@Service
public class PedidoService {

    private PedidoDAO pedidoDAO;
    private ClienteDAO clienteDAO;
    private ItemPedidoService itemPedidoService;

    @Autowired
    public PedidoService(PedidoDAO pedidoDAO, ClienteDAO clienteDAO, ItemPedidoService itemPedidoService) {
        this.pedidoDAO = pedidoDAO;
        this.clienteDAO = clienteDAO;
        this.itemPedidoService = itemPedidoService;
    }

    public Pedido buscarPorId(Long id) {
        return pedidoDAO.findById(id);
    }

    public List<PedidoListaDTO> listarPedidos() {

        List<Pedido> pedidos = pedidoDAO.find();

        List<PedidoListaDTO> dtos = new ArrayList<PedidoListaDTO>();

        for (Pedido pedido : pedidos) {
            dtos.add(new PedidoListaDTO(pedido));
        }

        return dtos;
    }

    public void incluir(PedidoDTO dto) {
        Pedido entity = new Pedido();

        entity.setCliente(clienteDAO.findById(dto.getIdCliente()));
        entity.setDataInclusao(new Date());
        entity.setValorBruto(new BigDecimal("0"));
        entity.setSituacao(SituacaoPedido.PENDENTE);

        pedidoDAO.save(entity);
    }

    public void atualizaValorBrutoPedido(Pedido pedido, BigDecimal valorTotal) {
        BigDecimal valorAtual = pedido.getValorBruto();
        BigDecimal valorAtualizado = valorAtual.add(valorTotal);
        pedido.setValorBruto(valorAtualizado);
        pedidoDAO.save(pedido);
    }

    public void atulizaDataDevolucao(Pedido pedido, Long prazo) {
        Date dataAtual = pedido.getDataEntrega();
        Date dataProduto = addDays(pedido.getDataInclusao(), prazo.intValue());
        if (dataAtual == null || dataProduto.after(dataAtual)) {
            pedido.setDataEntrega(dataProduto);
            pedidoDAO.save(pedido);
        }
    }

    private Date addDays(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        return c.getTime();
    }

    public void processaPedido(Long id) {
        Pedido pedido = buscarPorId(id);
        if (pedido.getSituacao() == SituacaoPedido.PENDENTE) {
            pedido.setSituacao(SituacaoPedido.PROCESSANDO);
            itemPedidoService.processandoItens(pedido.getItens());
            pedidoDAO.save(pedido);
        }
    }

    public void encerraPedido(Long id) {
        Pedido pedido = buscarPorId(id);
        if (pedido.getSituacao() == SituacaoPedido.PROCESSADO) {
            pedido.setSituacao(SituacaoPedido.ENCERRADO);
            pedidoDAO.save(pedido);
        }
    }

    public void cancelaPedido(Long id) {
        Pedido pedido = buscarPorId(id);
        if (pedido.getSituacao() != SituacaoPedido.ENCERRADO) {
            pedido.setSituacao(SituacaoPedido.CANCELADO);
            pedidoDAO.save(pedido);
        }
    }

}
