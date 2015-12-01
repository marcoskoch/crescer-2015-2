package br.com.cwi.crescer.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Item.SituacaoItem;

public class ItemDTO {

    private Long idItem;

    private Long idPedido;

    private Long idProduto;

    @NotNull
    private BigDecimal peso;

    private BigDecimal valorUnitario;

    private BigDecimal valorTotal;

    private SituacaoItem situacao;

    public ItemDTO() {

    }

    public ItemDTO(Item entity) {
        this.idItem = entity.getIdItem();
        this.idPedido = entity.getPedido().getIdPedido();
        this.idProduto = entity.getProduto().getIdProduto();
        this.peso = entity.getPeso();
        this.valorUnitario = entity.getValorUnitario();
        this.valorTotal = entity.getValorTotal();
        this.situacao = entity.getSituacao();
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public SituacaoItem getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoItem situacao) {
        this.situacao = situacao;
    }

}
