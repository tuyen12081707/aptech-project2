package aptech.project2.service;

import aptech.project2.entities.Users;

import java.util.List;

public interface UserService {

    boolean create(Users users) throws Exception;

    boolean update(Users users) throws Exception;

    boolean deleteById(int id) throws Exception;

    Users findById(int id) throws Exception;

    List<Users> findAll() throws Exception;
}
