/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2;

import aptech.project2.GUI.Login;
import aptech.project2.utilities.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;

/**
 * @author Admin
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Login l = new Login();
        l.setVisible(true);
       
    }


}
