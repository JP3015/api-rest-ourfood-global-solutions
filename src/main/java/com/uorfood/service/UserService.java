package com.uorfood.service;

import com.uorfood.dao.implementation.UserImplementation;
import com.uorfood.ddd.Users;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserImplementation userDao = new UserImplementation();

    public UserService() throws SQLException {
    }

    public List<Users> getAllUsers() {
        return userDao.getUsersAll();
    }


    public List<Users> getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    public List<Users> getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    public void insertUsers(Users users) {
        userDao.insertUsers(users);
    }

    public void editUsers(Users users, Integer id) {
        userDao.editUsers(users, id);
    }

    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

}
