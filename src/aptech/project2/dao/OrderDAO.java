/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.dao;

import aptech.project2.entities.Order;
import aptech.project2.utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderDAO implements IOrderDAO {

    @Override
    public boolean create(Order object) throws Exception {

        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBConnection.getConnection();
            stm = con.prepareStatement("INSERT INTO orders(transaction_id, product_id, quantity, amount, data, status) values (?,?,?,?,?,?)");

            stm.setInt(1, object.getTransaction().getId());
            stm.setInt(2, object.getProduct().getId());
            stm.setInt(3, object.getQuantity());
            stm.setFloat(4, object.getAmount());
            stm.setString(5, object.getData());
            stm.setInt(6, object.getStatus());
            return stm.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnection.closeConnection();
        }
    }

    @Override
    public boolean update(Order object) throws Exception {

        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBConnection.getConnection();
            stm = con.prepareStatement("update orders set transaction_id = ? ,product_id = ?, quantity = ?, amount = ?, data = ?, status = ? where id = ?");

            stm.setInt(1, object.getTransaction().getId());
            stm.setInt(2, object.getProduct().getId());
            stm.setInt(3, object.getQuantity());
            stm.setFloat(4, object.getAmount());
            stm.setString(5, object.getData());
            stm.setInt(6, object.getStatus());
            stm.setInt(7, object.getId());

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
            stm = con.prepareStatement("delete from oders where id = ? ");

            stm.setInt(1, id);

            return stm.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnection.closeConnection();
        }
    }

    @Override
    public Order findById(int id) throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBConnection.getConnection();
            stm = con.prepareStatement("select * from orders where id = ?");
            stm.setInt(0, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.getTransaction().setId(rs.getInt("id"));
                order.getProduct().setId(rs.getInt("id"));

                order.setQuantity(rs.getInt(rs.getInt("quantity")));
                order.setAmount(rs.getFloat("amount"));
                order.setData(rs.getString("data"));
                order.setStatus(rs.getInt("status"));
                return order;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnection.closeConnection();
        }
        return null;

    }

    @Override
    public List<Order> findAll() throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        List<Order> allOrders = new ArrayList<>();
        try {
            con = DBConnection.getConnection();
            stm = con.prepareStatement("select * from orders");
            rs = stm.executeQuery();

            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.getTransaction().setId(rs.getInt("id"));
                order.getProduct().setId(rs.getInt("id"));

                order.setQuantity(rs.getInt(rs.getInt("quantity")));
                order.setAmount(rs.getFloat("amount"));
                order.setData(rs.getString("data"));
                order.setStatus(rs.getInt("status"));
                allOrders.add(order);
            }
            return allOrders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnection.closeConnection();
        }
    }

}
