package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ServicoDAO;
import br.com.cwi.crescer.domain.Servico;

@Service
public class ServicoService {

    private ServicoDAO servicoDAO;

    @Autowired
    public ServicoService(ServicoDAO servicoDAO) {
        super();
        this.servicoDAO = servicoDAO;
    }

    public Servico buscarPorId(Long id) {
        return servicoDAO.findById(id);
    }

}
