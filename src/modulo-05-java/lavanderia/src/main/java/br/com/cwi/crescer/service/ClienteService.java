package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.CidadeDAO;
import br.com.cwi.crescer.dao.ClienteDAO;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.dto.ClienteResumoDTO;
import br.com.cwi.crescer.mapper.ClienteMapper;

@Service
public class ClienteService {

    private ClienteDAO clienteDAO;
    private CidadeDAO cidadeDAO;

    @Autowired
    public ClienteService(ClienteDAO clienteDAO, CidadeDAO cidadeDAO) {
        this.clienteDAO = clienteDAO;
        this.cidadeDAO = cidadeDAO;
    }

    public List<ClienteResumoDTO> listarClientes() {

        List<Cliente> clientes = clienteDAO.find();

        List<ClienteResumoDTO> dtos = new ArrayList<ClienteResumoDTO>();

        for (Cliente cliente : clientes) {
            dtos.add(new ClienteResumoDTO(cliente));
        }

        return dtos;
    }

    public List<Cliente> listarClientesAtivos() {

        List<Cliente> clientes = clienteDAO.findBySituacao(SituacaoCliente.ATIVO);
        return clientes;

    }

    public ClienteDTO buscarClientePorId(Long id) {
        return ClienteMapper.toDTO(clienteDAO.findById(id));
    }

    public void atualizar(ClienteDTO dto) {

        Cliente entity = clienteDAO.findById(dto.getId());

        ClienteMapper.merge(dto, entity);

        entity.setCidade(cidadeDAO.findById(dto.getIdCidade()));

        clienteDAO.save(entity);
    }

    public void incluir(ClienteDTO dto) {

        Cliente entity = ClienteMapper.getNewEntity(dto);
        entity.setSituacao(SituacaoCliente.ATIVO);
        entity.setCidade(cidadeDAO.findById(dto.getIdCidade()));

        clienteDAO.save(entity);
    }

    public void remover(ClienteDTO dto) {
        clienteDAO.delete(dto.getId());
    }

    public void desativar(ClienteDTO dto) {
        Cliente entity = clienteDAO.findById(dto.getId());
        entity.setSituacao(SituacaoCliente.INATIVO);
        clienteDAO.save(entity);
    }

}
