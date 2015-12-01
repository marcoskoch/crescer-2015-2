package br.com.cwi.crescer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ItemDAO;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Item.SituacaoItem;

@Service
public class ItemPedidoService {

    private ItemDAO itemDAO;

    @Autowired
    public ItemPedidoService(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    public void processandoItens(List<Item> itens) {
        for (Item item : itens) {
            item.setSituacao(SituacaoItem.PROCESSANDO);
            itemDAO.save(item);
        }
    }

}
