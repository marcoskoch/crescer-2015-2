package br.com.cwi.crescer.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Users;

public class UserDAOTest extends AbstractInfrastructureTest {

    @Autowired
    private UsersDAO userDAO;

    @Test
    public void devaBuscarPorNomeDeUsuario() throws Exception {
        Users user = userDAO.findByUserName("admin");
        Assert.assertNotNull(user);
    }

}
