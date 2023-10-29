package ru.onecommitman.springcourse.dao;


import ru.onecommitman.springcourse.model.User;

import java.util.List;

public interface UserDao {

    void create(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    void updateUser(Long id, User user);

    void deleteUser(Long id);


}