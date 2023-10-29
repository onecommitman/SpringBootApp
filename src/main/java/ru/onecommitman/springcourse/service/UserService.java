package ru.onecommitman.springcourse.service;


import ru.onecommitman.springcourse.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void deleteUserById(Long id);

    List<User> getAllUsers();

    User getUserByID(Long id);

    void updateUser(Long id, User user);

}