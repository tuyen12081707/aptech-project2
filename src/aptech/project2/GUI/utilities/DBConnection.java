/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.GUI.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DBConnection {
    public static Connection conn;

    public static Connection getConnection() {

        try {
            if (conn == null || conn.isClosed()) {
                String url ="";
                System.out.println("Connecting...");
                Class.forName("jdbc");
                conn = DriverManager.getConnection(url,"localhost","");
            }
        } catch (SQLException | ClassNotFoundException  ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;

    }
    
    
}
