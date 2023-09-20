package com.backendproject.twitterclone.service;

import com.backendproject.twitterclone.entity.User;
import com.backendproject.twitterclone.responses.UserResponse;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User find(int id);

    User save(User user);

    void delete(User user);

    User updateOneUser(User user, int id);

    User deleteOneUser(int id);

    UserResponse getUserWithId(int id);

    User getOneUserByName(String userName);
}
