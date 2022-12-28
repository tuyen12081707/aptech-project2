/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.service.impl;

import aptech.project2.dao.AuthDAO;
import aptech.project2.dao.AuthDAOImpl;
import aptech.project2.dao.IUserDAO;
import aptech.project2.dao.UserDAO;
import aptech.project2.entities.Users;
import aptech.project2.service.AuthService;

/**
 *
 * @author protu
 */
public class AuthServiceImpl implements AuthService {

    private final AuthDAO authDAO;

    public AuthServiceImpl() {
        authDAO = new AuthDAOImpl();
    }

    @Override
    public boolean login(Users users) throws Exception {
        if (this.authDAO.login(users)) {
            System.out.println("Login thành công!");
        } else {
            System.out.println("Login false");
        }
        return this.authDAO.login(users);

    }
}
