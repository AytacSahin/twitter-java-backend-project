package com.backendproject.twitterclone.repository;

import com.backendproject.twitterclone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
