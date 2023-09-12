package com.backendproject.twitterclone.service;

import com.backendproject.twitterclone.entity.User;
import com.backendproject.twitterclone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        //TODO handle exceptions
        return userRepository.findAll();
    }

    @Override
    public User find(int id) {
        //TODO handle exceptions
        Optional<User> user = userRepository.findById(id);
        return user.isPresent() ? user.get() : null;
    }

    @Override
    public User save(User user) {
        //TODO handle exceptions
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        //TODO handle exceptions
        userRepository.delete(user);
    }
    @Override
    public User updateOneUser(User user, int id) {
        //TODO handle exceptions
        User founded = find(id);
        if (founded != null) {
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User deleteOneUser(int id) {
        //TODO handle exceptions
        User founded = find(id);
        userRepository.delete(founded);
        return founded;
    }
}
