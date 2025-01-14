/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filtersec.dao;

import com.mycompany.filtersec.model.UserCredentials;
import jakarta.ejb.Stateless;

@Stateless
public class UserCredentialsDao extends AbstractDao<UserCredentials,Long> {
    public UserCredentialsDao() {
        super(UserCredentials.class);
    }
    public UserCredentials findByUsernameAndPassword(String username, String password) {
        return em.createNamedQuery("UserCredentials.findByUsernameAndPassword",UserCredentials.class)
                .setParameter("un",username)
                .setParameter("pw",password)
                .getResultList().stream().findFirst().orElse(null);
    }
}
