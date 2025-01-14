/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filtersec.controller;

import com.mycompany.filtersec.dao.UserCredentialsDao;
import com.mycompany.filtersec.util.JSF;
import java.io.IOException;
import java.io.Serializable;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;

@Named
@ViewScoped
public class LoginBean implements Serializable {

    @Inject
    private UserBean userBean;

    @EJB
    private UserCredentialsDao userCredentialsDao;

    private String username;
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

    // login action
    public void login() throws IOException, ServletException {
        if (userCredentialsDao.findByUsernameAndPassword(username, password) != null) {
            userBean.setUsername(username);
            JSF.redirect("index.xhtml");
        } else {
            JSF.addErrorMessage("Invalid credentials");
        }
    }
    // logout action
    public void logout() throws IOException {
        JSF.invalidateSession();
        JSF.redirect("index.xhtml");
    }


}
