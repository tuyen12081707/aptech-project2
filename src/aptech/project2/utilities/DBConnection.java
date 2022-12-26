/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.utilities;

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
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/salescar?useSSL=false";
                String username = "root";
                String password = "";
                System.out.println("Connecting...");
                conn = DriverManager.getConnection(url, username, password);
                System.out.println(conn);
            }
        } catch (SQLException  | ClassNotFoundException  ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            return conn;

        }

    

    

    

    public static void closeConnection() {
        try {
            if (conn != null && conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("Failed to close DBConnection");
        }
    }
}
