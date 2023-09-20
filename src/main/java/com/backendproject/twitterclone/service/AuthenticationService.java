package com.backendproject.twitterclone.service;

import com.backendproject.twitterclone.entity.Role;
import com.backendproject.twitterclone.entity.User;
import com.backendproject.twitterclone.repository.RoleRepository;
import com.backendproject.twitterclone.repository.UserRepository;
import com.backendproject.twitterclone.responses.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class AuthenticationService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private TokenService tokenService;

    @Autowired
    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    public User register(String name, String phoneNumber, String email, String nick, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER");
        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);

        User user = new User();
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setEmail(email);
        user.setNick(nick);
        user.setPassword(encodedPassword);
        user.setCreatedAt(LocalDateTime.now());
        user.setAuthorities(authorities);
        return userRepository.save(user);
    }

    public LoginResponse login(String email, String password){
        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password));
            String token = tokenService.generateJwtToken(auth);
            return new LoginResponse(userRepository.findUserByEmail(email).get(), token);
        } catch (BadCredentialsException ex) {
            throw new BadCredentialsException("Invalid Credentials");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("An error occurred during authentication", ex);
        }
    }




}
