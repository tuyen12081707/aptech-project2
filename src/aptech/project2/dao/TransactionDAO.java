/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.dao;

import aptech.project2.entities.Order;
import aptech.project2.entities.Transaction;
import aptech.project2.utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author protu
 */
public class TransactionDAO implements ITransactionDAO {

    @Override
    public boolean create(Transaction object) throws Exception {

        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBConnection.getConnection();
            stm = con.prepareStatement("INSERT INTO transaction(status, user_id, amount, payment, payment_info, message) values (?,?,?,?,?,?)");
            stm.setInt(0, object.getStatus());
            stm.setInt(1, object.getUser().getId());
            stm.setInt(2, object.getAmount());
            stm.setString(3, object.getPayment());
            stm.setString(4, object.getPaymentInfo());
            stm.setString(5, object.getMessage());
            return stm.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnection.closeConnection();
        }
    }

    @Override
    public boolean update(Transaction object) throws Exception {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBConnection.getConnection();
            stm = con.prepareStatement("UPDATE transaction SET status = ?, user_id = ? , amount = ?, payment = ?, payment_info = ?, message = ? where id = ?");

            stm.setInt(0, object.getStatus());
            stm.setInt(1, object.getUser().getId());
            stm.setInt(2, object.getAmount());
            stm.setString(3, object.getPayment());
            stm.setString(4, object.getPaymentInfo());
            stm.setString(5, object.getMessage());
            stm.setInt(6, object.getId());
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
            stm = con.prepareStatement("DELECT from transaction where id = ?");
            stm.setInt(1, id);
            return stm.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnection.closeConnection();
        }
    }

    @Override
    public Transaction findById(int id) throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBConnection.getConnection();
            stm = con.prepareStatement("select * from orders where id = ?");
            stm.setInt(0, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(rs.getInt("id"));
                transaction.setStatus(rs.getInt("status"));
                transaction.getUser().setId(rs.getInt("user_id"));
                transaction.setAmount(rs.getInt("amount"));
                transaction.setPayment(rs.getString("payment"));
                transaction.setPaymentInfo(rs.getString("payment_info"));
                transaction.setMessage(rs.getString("message"));
                return transaction;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnection.closeConnection();
        }
        return null;
    }

    @Override
    public List<Transaction> findAll() throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBConnection.getConnection();
            stm = con.prepareStatement("select * from orders ");
            List<Transaction> transactionArr = new ArrayList<>();
            rs = stm.executeQuery();
            if (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(rs.getInt("id"));
                transaction.setStatus(rs.getInt("status"));
                transaction.getUser().setId(rs.getInt("user_id"));
                transaction.setAmount(rs.getInt("amount"));
                transaction.setPayment(rs.getString("payment"));
                transaction.setPaymentInfo(rs.getString("payment_info"));
                transaction.setMessage(rs.getString("message"));
                transactionArr.add(transaction);
                return transactionArr;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnection.closeConnection();
        }
        return null;
    }

}
