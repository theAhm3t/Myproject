package com.mycompany.jakartasec.service;

import com.mycompany.jakartasec.dao.UserCredentialsDao;
import com.mycompany.jakartasec.model.UserCredentials;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;


/**
 * Service layer, may contain additional logic, in this case only forwards to UserCredentialsDao.
 */
@Stateless
public class UserService {
    @EJB
    private UserCredentialsDao userDao;

    public UserCredentials findByUsername(String username) {
        return userDao.findUserByUsername(username);
    }
}
