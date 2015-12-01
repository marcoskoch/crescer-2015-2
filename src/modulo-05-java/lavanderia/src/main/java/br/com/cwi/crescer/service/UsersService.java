package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.UsersDAO;
import br.com.cwi.crescer.domain.Users;
import br.com.cwi.crescer.domain.Users.Enable;
import br.com.cwi.crescer.dto.UsersDTO;
import br.com.cwi.crescer.mapper.UsersMapper;

@Service
public class UsersService {

    private UsersDAO usersDAO;

    @Autowired
    public UsersService(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    public UsersDTO buscarUsuarioPorNomeDeUsuario(String userName) {
        return UsersMapper.toDTO(usersDAO.findByUserName(userName));
    }

    public List<UsersDTO> buscarUsuariosAtivos() {
        List<Users> users = usersDAO.findBySituation(Enable.ENABLED);
        List<UsersDTO> usersDTO = new ArrayList<UsersDTO>();

        for (Users user : users) {
            usersDTO.add(UsersMapper.toDTO(user));
        }

        return usersDTO;
    }
}
