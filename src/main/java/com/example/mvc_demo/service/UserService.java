package com.example.mvc_demo.service;

import com.example.mvc_demo.domain.User;

import java.util.List;

public interface UserService {
    User getUserByUsername(String username);

    User addUser(User user);

    Iterable<User> getUsers();

    List<String> getUsernames();
}
