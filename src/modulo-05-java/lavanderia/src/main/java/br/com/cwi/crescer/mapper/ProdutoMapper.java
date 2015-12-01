package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.dto.ProdutoDTO;

public class ProdutoMapper {

    public static Produto getNewEntity(ProdutoDTO dto) {
        Produto entity = new Produto();
        entity.setIdProduto(dto.getIdProduto());
        entity.setPrazo(dto.getPrazo());
        entity.setValor(dto.getValor());
        return entity;
    }

    public static ProdutoDTO toDTO(Produto entity) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setIdProduto(entity.getIdProduto());
        dto.setIdMaterial(entity.getMaterial().getIdMaterial());
        dto.setIdServico(entity.getServico().getIdServico());
        dto.setValor(entity.getValor());
        dto.setPrazo(entity.getPrazo());
        dto.setSituacao(entity.getSituacao());
        return dto;
    }

}
