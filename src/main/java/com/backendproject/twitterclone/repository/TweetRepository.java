package com.backendproject.twitterclone.repository;

import com.backendproject.twitterclone.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Integer> {

    List<Tweet> findByUserId(Integer integer);
}
