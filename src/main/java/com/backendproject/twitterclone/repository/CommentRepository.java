package com.backendproject.twitterclone.repository;

import com.backendproject.twitterclone.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByUserIdAndTweetId(Integer userId, Integer tweetId);

    List<Comment> findByUserId(Integer userId);

    List<Comment> findByTweetId(Integer tweetId);
}
