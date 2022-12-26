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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoang Son
 */
public class UserDAO implements IUserDAO{

    @Override
    public boolean create(Users object) throws Exception {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBConnection.getConnection();
            stm = con.prepareStatement("insert into user(name, email, phone, address, role, password) values (?,?,?,?,?,?)");

            stm.setString(1, object.getName());
            stm.setString(2,object.getEmail());
            stm.setString(3, object.getPhone());
            stm.setString(4,object.getAddress());
            stm.setInt(5, object.getRole());
            stm.setString(6, object.getPassword());
            return stm.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnection.closeConnection();
        }
    }

    @Override
    public boolean update(Users object) throws Exception {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBConnection.getConnection();
            stm = con.prepareStatement("update user set name = ? ,email = ?, phone = ?, address = ?, role = ?, password = ? where id = ?");

            stm.setString(1, object.getName());
            stm.setString(2,object.getEmail());
            stm.setString(3, object.getPhone());
            stm.setString(4,object.getAddress());
            stm.setInt(5,object.getRole());
            stm.setString(6,object.getPassword());
            stm.setInt(7,object.getId());

            return stm.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnection.closeConnection();
        }
    }

    @Override
    public boolean deleteById(int id) throws Exception {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBConnection.getConnection();
            stm = con.prepareStatement("delete from user where id = ?");

            stm.setInt(1, id);
           
            return stm.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnection.closeConnection();
        }
    }

    @Override
    public Users findById(int id) throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs =null;
        
        Users userbyid = new Users();
        try {
            con = DBConnection.getConnection();
            stm = con.prepareStatement("slect * from user where id = ?");
            rs = stm.executeQuery();
            stm.setInt(1, id);
            if(stm.executeUpdate() > 0){
               int iduser = rs.getInt("id");
               String name = rs.getString("name");
               String email = rs.getString("email");
               String phone = rs.getString("phone");
               String address = rs.getString("address");
               int role = rs.getInt("role");
               String password = rs.getString("password");
               
               userbyid = new Users(iduser, name,email, phone, address, role, password);
            }
            return userbyid;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnection.closeConnection();
        }
    }

    @Override
    public List<Users> findAll() throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs =null;
        
        List<Users> allusers = new ArrayList<>();
        try {
            con = DBConnection.getConnection();
            stm = con.prepareStatement("slect * from user");
            rs = stm.executeQuery();

            while(rs.next()){
               int iduser = rs.getInt("id");
               String name = rs.getString("name");
               String email = rs.getString("email");
               String phone = rs.getString("phone");
               String address = rs.getString("address");
               int role = rs.getInt("role");
               String password = rs.getString("password");
               
               allusers.add(new Users(iduser, name,email, phone, address, role, password));
            }
            return allusers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnection.closeConnection();
        }
    }
    
     public boolean existUser(String name, String password){
        Connection con = null;
        PreparedStatement stm =null;
        ResultSet rs = null;

        try {
            con = DBConnection.getConnection();
            stm = con.prepareStatement("select * from user where name = ? and password = ?");
            stm.setString(1,name);
            stm.setString(2, password);
            rs = stm.executeQuery();

            return rs.next();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBConnection.closeConnection();
        }

    }
     
    public Users findByName(String name) throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs =null;
        
        Users userbyid = new Users();
        try {
            con = DBConnection.getConnection();
            stm = con.prepareStatement("select * from user where name = ?");
            stm.setString(1, name);
            rs = stm.executeQuery();
            
            while(rs.next()){
               int iduser = rs.getInt("id");
               String nameuser = rs.getString("name");
               String email = rs.getString("email");
               String phone = rs.getString("phone");
               String address = rs.getString("address");
               int role = rs.getInt("role");
               String password = rs.getString("password");
               
               userbyid = new Users(iduser, nameuser,email, phone, address, role, password);
            }
            return userbyid;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnection.closeConnection();
        }
    }
}
