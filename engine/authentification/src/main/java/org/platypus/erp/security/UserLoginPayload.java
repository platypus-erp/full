package org.platypus.erp.security;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class UserLoginPayload {

    @NotNull
    @NotBlank
    private String userid;

    @NotNull
    @NotBlank
    private String pwd;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return pwd;
    }

    public void setPassword(String password) {
        this.pwd = password;
    }

    @Override
    public String toString() {
        return "UserLoginPayload{" +
                "userid='" + userid + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
