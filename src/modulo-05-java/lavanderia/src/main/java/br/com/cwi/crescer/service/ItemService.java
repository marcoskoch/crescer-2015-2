package br.com.cwi.crescer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ItemDAO;
import br.com.cwi.crescer.dao.PedidoDAO;
import br.com.cwi.crescer.dao.ProdutoDAO;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Item.SituacaoItem;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.dto.ItemDTO;
import br.com.cwi.crescer.mapper.ItemMapper;

@Service
public class ItemService {

    private ItemDAO itemDAO;
    private PedidoDAO pedidoDAO;
    private ProdutoDAO produtoDAO;
    private PedidoService pedidoService;

    @Autowired
    public ItemService(ItemDAO itemDAO, PedidoDAO pedidoDAO, ProdutoDAO produtoDAO, PedidoService pedidoService) {
        this.itemDAO = itemDAO;
        this.pedidoDAO = pedidoDAO;
        this.produtoDAO = produtoDAO;
        this.pedidoService = pedidoService;
    }

    public Item buscarPorId(Long id) {
        return itemDAO.findById(id);
    }

    public List<Item> listarItensPedido(Pedido pedido) {
        List<Item> itens = itemDAO.findByPedido(pedido);
        return itens;
    }

    public void incluir(ItemDTO dto) {
        Item entity = ItemMapper.getNewEntity(dto);
        entity.setPedido(pedidoDAO.findById(dto.getIdPedido()));
        entity.setProduto(produtoDAO.findById(dto.getIdProduto()));
        entity.setValorUnitario(entity.getProduto().getValor());
        entity.setValorTotal(entity.getValorUnitario().multiply(entity.getPeso()));
        entity.setSituacao(SituacaoItem.PENDENTE);

        if (entity.getPedido().getSituacao() == SituacaoPedido.PENDENTE) {
            pedidoService.atualizaValorBrutoPedido(entity.getPedido(), entity.getValorTotal());
            pedidoService.atulizaDataDevolucao(entity.getPedido(), entity.getProduto().getPrazo());
            itemDAO.save(entity);
        }

    }

    public void processaItem(Long id) {
        Item item = buscarPorId(id);
        if (item.getSituacao() == SituacaoItem.PROCESSANDO) {
            item.setSituacao(SituacaoItem.PROCESSADO);
            itemDAO.save(item);
        }
        pedidoService.verificaSeTodosItensEstaoProcessados(item.getPedido());
    }
}
