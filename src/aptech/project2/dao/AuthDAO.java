/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.dao;

import aptech.project2.entities.Users;

/**
 *
 * @author protu
 */
public interface AuthDAO{
    public boolean login(Users user);
   
}
