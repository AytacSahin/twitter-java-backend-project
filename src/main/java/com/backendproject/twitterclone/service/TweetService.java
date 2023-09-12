package com.backendproject.twitterclone.service;

import com.backendproject.twitterclone.entity.Tweet;
import com.backendproject.twitterclone.requests.TweetCreateRequest;
import com.backendproject.twitterclone.requests.TweetUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface TweetService {
    List<Tweet> findAll();
    Tweet find(int id);
    Tweet save(TweetCreateRequest newTweet);
    Tweet delete(int id);
    List<Tweet> getAllTweets(Optional<Integer> userId);

    Tweet updateOneTweetById(TweetUpdateRequest tweetUpdateRequest, int id);
}
