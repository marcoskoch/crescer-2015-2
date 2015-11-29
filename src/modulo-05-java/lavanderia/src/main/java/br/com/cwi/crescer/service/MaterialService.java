package br.com.cwi.crescer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.MaterialDAO;
import br.com.cwi.crescer.domain.Material;

@Service
public class MaterialService {

    private MaterialDAO materialDAO;

    @Autowired
    public MaterialService(MaterialDAO materialDAO) {
        super();
        this.materialDAO = materialDAO;
    }

    public Material buscarPorId(Long id) {
        return materialDAO.findById(id);
    }

    public List<Material> listar() {
        return materialDAO.listAll();
    }

}
