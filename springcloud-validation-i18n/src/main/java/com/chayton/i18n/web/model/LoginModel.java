package com.chayton.i18n.web.model;

import javax.validation.constraints.NotBlank;

/**
 * @Author: ChaytonRiver
 * @Date: 2019-06-04 11:36
 */
public class LoginModel {

    @NotBlank(message = "{username.notblank.message}")
    private String username;
    @NotBlank(message = "{password.notblank.message}")
    private String password;

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
}
