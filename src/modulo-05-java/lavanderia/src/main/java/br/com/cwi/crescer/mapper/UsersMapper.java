package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.domain.Users;
import br.com.cwi.crescer.dto.UsersDTO;

public class UsersMapper {

    public static Users getNewEntity(UsersDTO dto) {
        Users entity = new Users();
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        return entity;
    }

    public static UsersDTO toDTO(Users entity) {
        UsersDTO dto = new UsersDTO();
        dto.setUsername(entity.getUsername());
        dto.setPassword(dto.getPassword());
        return dto;
    }

    public static Users merge(UsersDTO dto, Users entity) {
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        return entity;
    }

}
