package com.backendproject.twitterclone.service;

import com.backendproject.twitterclone.entity.Tweet;

import java.util.List;

public interface TweetService {
    List<Tweet> findAll();
    Tweet find(int id);
    Tweet save(Tweet tweet);
    void delete(Tweet tweet);
}
