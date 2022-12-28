/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.dao;

import aptech.project2.entities.Users;
import aptech.project2.utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author protu
 */
public class AuthDAOImpl implements AuthDAO {

    @Override
    public boolean login(Users users) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        Users userbyid = new Users();
        try {
            con = DBConnection.getConnection();
            stm = con.prepareStatement("select * from user where username = ? and password = ?");
            stm.setString(1, users.getUsername());
            stm.setString(2, users.getPassword());
               
            rs = stm.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnection.closeConnection();
        }

    }

}
