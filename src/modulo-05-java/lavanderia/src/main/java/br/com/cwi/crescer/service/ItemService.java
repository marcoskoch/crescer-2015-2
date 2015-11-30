package br.com.cwi.crescer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ItemDAO;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Pedido;

@Service
public class ItemService {

    private ItemDAO itemDAO;

    @Autowired
    public ItemService(ItemDAO itemDAO) {
        super();
        this.itemDAO = itemDAO;
    }

    public Item buscarPorId(Long id) {
        return itemDAO.findById(id);
    }

    public List<Item> listarItensPedido(Pedido pedido) {
        List<Item> itens = itemDAO.findByPedido(pedido);
        return itens;
    }

}
