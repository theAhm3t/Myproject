/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jakartasec.dao;

import com.mycompany.jakartasec.model.UserCredentials;
import jakarta.ejb.Stateless;

@Stateless
public class UserCredentialsDao extends AbstractDao<UserCredentials,Long> {
    public UserCredentialsDao() {
        super(UserCredentials.class);
    }
    public UserCredentials findUserByUsername(String username) {
        return em.createNamedQuery("UserCredentials.findByUsername",UserCredentials.class)
                .setParameter("un",username)
                .getResultList().stream().findFirst().orElse(null);
    }
}
