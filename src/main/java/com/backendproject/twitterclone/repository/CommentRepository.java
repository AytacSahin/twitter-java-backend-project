package com.backendproject.twitterclone.repository;

import com.backendproject.twitterclone.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
