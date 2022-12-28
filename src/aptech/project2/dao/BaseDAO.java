/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.dao;

import java.util.List;

/**
 * @author Admin
 */
public interface BaseDAO<T> {

    boolean create(T object) throws Exception;

    boolean update(T object) throws Exception;

    boolean deleteById(int id) throws Exception;

    T findById(int id) throws Exception;

    List<T> findAll() throws Exception;

}
