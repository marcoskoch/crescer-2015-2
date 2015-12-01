package br.com.cwi.crescer.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class UsersDTO {

    @NotBlank
    @Length(max = 100)
    private String username;

    @NotBlank
    @Length(max = 32)
    private String password;

    @NotBlank
    private Long enable;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Long getEnable() {
        return enable;
    }


    public void setEnable(Long enable) {
        this.enable = enable;
    }


}
