package aptech.project2.service.impl;

import aptech.project2.common.CommonException;
import aptech.project2.common.ValidateCommon;
import aptech.project2.dao.IUserDAO;
import aptech.project2.dao.UserDAO;
import aptech.project2.entities.Users;
import aptech.project2.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final IUserDAO iUserDAO;

    public UserServiceImpl() {
        iUserDAO = new UserDAO();
    }

    @Override
    public boolean create(Users users) throws Exception {
        // Validate đầu vào cho việc create User
        ValidateCommon.validateNullObject(users.getName(), "Name");
        ValidateCommon.validateNullObject(users.getPassword(), "Password");
        ValidateCommon.validateNullObject(users.getRole(), "Role");
        return this.iUserDAO.create(users);
    }

    @Override
    public boolean update(Users users) throws Exception {
        // Validate đầu vào cho việc update User
        ValidateCommon.validateNullObject(users.getId(), "Id");
        return this.iUserDAO.update(users);
    }

    @Override
    public boolean deleteById(int id) throws Exception {
        return iUserDAO.deleteById(id);
    }

    @Override
    public Users findById(int id) throws Exception {
        ValidateCommon.validateNullObject(id, "Id");
        return iUserDAO.findById(id);
    }

    @Override
    public List<Users> findAll() throws Exception {
        return iUserDAO.findAll();
    }
}
