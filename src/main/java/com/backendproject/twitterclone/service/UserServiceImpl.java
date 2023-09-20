package com.backendproject.twitterclone.service;

import com.backendproject.twitterclone.entity.User;
import com.backendproject.twitterclone.repository.UserRepository;
import com.backendproject.twitterclone.responses.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User is not valid"));
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

    @Override
    public UserResponse getUserWithId(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return new UserResponse(user.get());
        }
        return null;
    }

    @Override
    public User getOneUserByName(String userName) {
        return userRepository.findByName(userName);
    }
}
