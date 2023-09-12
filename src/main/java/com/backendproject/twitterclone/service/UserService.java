package com.backendproject.twitterclone.service;

import com.backendproject.twitterclone.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User find(int id);
    User save(User user);
    void delete(User user);
    User updateOneUser(User user, int id);

    User deleteOneUser(int id);
}
