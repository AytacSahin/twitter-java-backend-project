package com.backendproject.twitterclone.repository;

import com.backendproject.twitterclone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByEmail(String email);

    User findByName(String userName);

}
