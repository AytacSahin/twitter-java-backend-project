package com.backendproject.twitterclone.repository;

import com.backendproject.twitterclone.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Integer> {
    List<Like> findByUserIdAndTweetId(Integer userId, Integer tweetId);

    List<Like> findByUserId(Integer userId);

    List<Like> findByTweetId(Integer tweetId);

    void deleteOneLike(int id);
}
