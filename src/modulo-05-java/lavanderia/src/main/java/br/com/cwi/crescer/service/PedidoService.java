package br.com.cwi.crescer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
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

    @Autowired
    public PedidoService(PedidoDAO pedidoDAO, ClienteDAO clienteDAO) {
        this.pedidoDAO = pedidoDAO;
        this.clienteDAO = clienteDAO;
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

}
