package com.backendproject.twitterclone.repository;

import com.backendproject.twitterclone.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Integer> {
}
