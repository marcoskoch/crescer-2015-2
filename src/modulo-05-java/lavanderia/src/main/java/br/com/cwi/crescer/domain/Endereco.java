package br.com.cwi.crescer.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Endereco {

    @Column(name = "Endereco", length = 50)
    private String endereco;

    @Column(name = "Bairro", length = 50)
    private String bairro;

    @Column(name = "CEP")
    private Long cep;

    @ManyToOne
    @JoinColumn(name = "IDCidade")
    private Cidade cidade;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

}
