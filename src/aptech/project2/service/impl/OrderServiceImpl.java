/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.service.impl;

import aptech.project2.common.ValidateCommon;
import aptech.project2.dao.IOrderDAO;
import aptech.project2.dao.OrderDAO;
import aptech.project2.entities.Order;
import aptech.project2.service.OrderService;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderServiceImpl implements OrderService {

    private final IOrderDAO iOrderDAO;

    public OrderServiceImpl() {
        iOrderDAO = new OrderDAO();
    }

    @Override
    public boolean create(Order order) throws Exception {
        ValidateCommon.validateNullObject(order.getQuantity(), "quantity");
        ValidateCommon.validateNullObject(order.getAmount(), "amount");
        ValidateCommon.validateNullObject(order.getData(), "data");
        return this.iOrderDAO.create(order);
    }

    @Override
    public boolean update(Order order) throws Exception {
        ValidateCommon.validateNullObject(order.getId(), "id");
        return this.iOrderDAO.update(order);
    }

    @Override
    public boolean deleteById(int id) throws Exception {
        return this.iOrderDAO.deleteById(id);
    }

    @Override
    public List<Order> findAll() throws Exception {
        return iOrderDAO.findAll();
    }

    @Override
    public Order findById(int id) throws Exception {
        ValidateCommon.validateNullObject(id, "Id");
        return this.iOrderDAO.findById(id);
    }

}
