/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2;

import aptech.project2.utilities.DBConnection;
import static aptech.project2.utilities.DBConnection.conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
      Connection conn = DBConnection.getConnection();
      if(conn != null){
          System.out.println("kết nối thành công");
      }
    }

}
