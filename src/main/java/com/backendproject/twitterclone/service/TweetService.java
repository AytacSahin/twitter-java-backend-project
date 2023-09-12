package com.backendproject.twitterclone.service;

import com.backendproject.twitterclone.entity.Tweet;
import com.backendproject.twitterclone.requests.TweetCreateRequest;
import com.backendproject.twitterclone.requests.TweetUpdateRequest;
import com.backendproject.twitterclone.responses.TweetResponse;

import java.util.List;
import java.util.Optional;

public interface TweetService {
    Tweet find(int id);
    Tweet save(TweetCreateRequest newTweet);
    Tweet delete(int id);
    List<TweetResponse> getAllTweets(Optional<Integer> userId);
    Tweet updateOneTweetById(TweetUpdateRequest tweetUpdateRequest, int id);
}
