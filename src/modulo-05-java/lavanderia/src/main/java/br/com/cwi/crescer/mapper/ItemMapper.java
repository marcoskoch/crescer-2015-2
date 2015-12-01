package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.dto.ItemDTO;

public class ItemMapper {

    public static Item getNewEntity(ItemDTO dto) {
        Item entity = new Item();
        entity.setIdItem(dto.getIdItem());
        entity.setPeso(dto.getPeso());
        return entity;
    }

}
