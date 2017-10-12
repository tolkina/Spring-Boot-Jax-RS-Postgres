package com.example.rest.service;

import com.example.rest.exception.UserAlreadyExistException;
import com.example.rest.exception.UserNotFoundException;
import com.example.rest.model.User;

import java.util.List;

public interface UserService {

    User retrieveUser(Long id) throws UserNotFoundException;

    List<User> retrieveAllUsers();

    void createUser(User user) throws UserAlreadyExistException;
}
