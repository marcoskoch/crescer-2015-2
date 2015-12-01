package br.com.cwi.crescer.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @Column(name = "username", length = 100)
    private String username;

    @Column(name = "password", length = 32)
    @Basic(optional = false)
    private String password;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "enabled")
    @Basic(optional = false)
    private Enable enabled;

    public static enum Enable {
        DISABLED, ENABLED
    }


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

    public Enable getEnabled() {
        return enabled;
    }

    public void setEnabled(Enable enabled) {
        this.enabled = enabled;
    }


}
