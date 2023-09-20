package com.backendproject.twitterclone.repository;

import com.backendproject.twitterclone.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByAuthority(String authority);
}
