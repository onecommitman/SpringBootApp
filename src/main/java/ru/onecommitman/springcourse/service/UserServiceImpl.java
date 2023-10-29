package ru.onecommitman.springcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.onecommitman.springcourse.dao.UserDao;
import ru.onecommitman.springcourse.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    public UserServiceImpl() {

    }

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    private UserDao userDao;


    public void saveUser(User user) {
        userDao.create(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userDao.deleteUser(id);
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByID(Long id) {
        User user = userDao.getUserById(id);
        return user;
    }

    @Override
    public void updateUser(Long id, User user) {
        userDao.updateUser(id, user);
    }

}