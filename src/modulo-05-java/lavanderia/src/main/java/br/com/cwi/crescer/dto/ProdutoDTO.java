package br.com.cwi.crescer.dto;

import java.math.BigDecimal;

import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Produto.SituacaoProduto;

public class ProdutoDTO {

    private Long idProduto;

    private Long idServico;

    private Long idMaterial;

    private BigDecimal valor;

    private Long prazo;

    private SituacaoProduto situacao;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Produto entity) {
        this.idProduto = entity.getIdProduto();
        this.idServico = entity.getServico().getIdServico();
        this.idMaterial = entity.getMaterial().getIdMaterial();
        this.valor = entity.getValor();
        this.prazo = entity.getPrazo();
        this.situacao = entity.getSituacao();
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public SituacaoProduto getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoProduto situacao) {
        this.situacao = situacao;
    }

    public Long getPrazo() {
        return prazo;
    }

    public void setPrazo(Long prazo) {
        this.prazo = prazo;
    }
}
