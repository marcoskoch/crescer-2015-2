package br.com.cwi.crescer.dto;

import java.math.BigDecimal;

import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.domain.Servico;

public class ProdutoListaDTO {

    private Long idProduto;

    private Servico servico;

    private Material material;

    private BigDecimal valor;

    private Long prazo;

    private SituacaoProduto situacao;

    public ProdutoListaDTO() {

    }

    public ProdutoListaDTO(Produto entity) {
        this.idProduto = entity.getIdProduto();
        this.servico = entity.getServico();
        this.material = entity.getMaterial();
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

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getPrazo() {
        return prazo;
    }

    public void setPrazo(Long prazo) {
        this.prazo = prazo;
    }

    public SituacaoProduto getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoProduto situacao) {
        this.situacao = situacao;
    }

}
