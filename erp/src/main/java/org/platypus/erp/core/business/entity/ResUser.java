package org.platypus.erp.core.business.entity;

import org.hibernate.validator.constraints.Email;
import org.platypus.erp.core.util.CoreTableName;
import org.platypus.erp.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


/**
 * Created by Alexis PASQUIER and Alexandre SALAUN on 01/08/16.
 *
 * @version 0.1
 * @since 0.1
 */
@Entity
@Table(name = CoreTableName.user)
@NamedQuery(name = "ResUser.findAll", query = "SELECT r FROM ResUser r")
public class ResUser extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    private Boolean active;

    @NotNull
    @Size(min=6, max = 64)
    @Email
    @Column(nullable = false, length = 64)
    private String login;

    @Column(name = "login_date")
    private LocalDateTime loginDate;

    private String password;

    private String signature;

    //<editor-fold desc="Getter Setter">
    public Boolean getActive() {
        return active;
    }

    public ResUser setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public ResUser setLogin(String login) {
        this.login = login;
        return this;
    }

    public LocalDateTime getLoginDate() {
        return loginDate;
    }

    public ResUser setLoginDate(LocalDateTime loginDate) {
        this.loginDate = loginDate;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ResUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getSignature() {
        return signature;
    }

    public ResUser setSignature(String signature) {
        this.signature = signature;
        return this;
    }
    //</editor-fold>
}