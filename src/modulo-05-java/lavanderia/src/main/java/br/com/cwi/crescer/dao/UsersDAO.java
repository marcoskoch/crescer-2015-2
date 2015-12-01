package br.com.cwi.crescer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Users;
import br.com.cwi.crescer.domain.Users.Enable;

@Repository
public class UsersDAO extends AbstractDAO {

    public Users findByUserName(String userName) {
        return em.createQuery("FROM Users u WHERE u.username = :userName", Users.class)
                .setParameter("userName", userName)
                .getSingleResult();
    }

    public List<Users> findBySituation(Enable enable) {
        return em.createQuery("FROM Users u WHERE u.enabled = :enable", Users.class)
                .setParameter("enable", enable)
                .getResultList();
    }

}
