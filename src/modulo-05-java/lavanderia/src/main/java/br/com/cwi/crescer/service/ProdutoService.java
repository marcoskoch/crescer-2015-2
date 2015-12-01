package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.MaterialDAO;
import br.com.cwi.crescer.dao.ProdutoDAO;
import br.com.cwi.crescer.dao.ServicoDAO;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.dto.ProdutoDTO;
import br.com.cwi.crescer.dto.ProdutoListaDTO;
import br.com.cwi.crescer.mapper.ProdutoMapper;

@Service
public class ProdutoService {

    private ProdutoDAO produtoDAO;
    private MaterialDAO materialDAO;
    private ServicoDAO servicoDAO;

    @Autowired
    public ProdutoService(ProdutoDAO produtoDAO, MaterialDAO materialDAO, ServicoDAO servicoDAO) {
        super();
        this.produtoDAO = produtoDAO;
        this.materialDAO = materialDAO;
        this.servicoDAO = servicoDAO;
    }

    public Produto buscarPorId(Long id) {
        return produtoDAO.findById(id);
    }

    public List<ProdutoListaDTO> listarProdutos() {

        List<Produto> produtos = produtoDAO.find();

        List<ProdutoListaDTO> dtos = new ArrayList<ProdutoListaDTO>();

        for (Produto produto : produtos) {
            dtos.add(new ProdutoListaDTO(produto));
        }

        return dtos;
    }

    public List<Produto> listarProdutosCombo() {
        List<Produto> produtos = produtoDAO.find();
        return produtos;
    }

    public void incluir(ProdutoDTO dto) {
        Produto entity = ProdutoMapper.getNewEntity(dto);
        entity.setSituacao(SituacaoProduto.ATIVO);
        entity.setMaterial(materialDAO.findById(dto.getIdMaterial()));
        entity.setServico(servicoDAO.findById(dto.getIdServico()));

        produtoDAO.save(entity);
    }

    public ProdutoDTO buscarClientePorId(Long id) {
        return ProdutoMapper.toDTO(produtoDAO.findById(id));
    }

}
