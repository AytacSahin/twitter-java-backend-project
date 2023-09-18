package com.backendproject.twitterclone.service;

import com.backendproject.twitterclone.entity.User;
import com.backendproject.twitterclone.repository.UserRepository;
import com.backendproject.twitterclone.security.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);
        return JwtUserDetails.create(user);
    }

public UserDetails loadUserById(int id) {
        User user = userRepository.findById(id).get();
        return JwtUserDetails.create(user);
}

}
