package com.backendproject.twitterclone.repository;

import com.backendproject.twitterclone.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Integer> {

}
