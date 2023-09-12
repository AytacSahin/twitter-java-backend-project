package com.backendproject.twitterclone.service;

import com.backendproject.twitterclone.entity.Tweet;
import com.backendproject.twitterclone.entity.User;
import com.backendproject.twitterclone.repository.TweetRepository;
import com.backendproject.twitterclone.requests.TweetCreateRequest;
import com.backendproject.twitterclone.requests.TweetUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TweetServiceImpl implements TweetService{

    private TweetRepository tweetRepository;
    private UserService userService;

    public TweetServiceImpl(TweetRepository tweetRepository, UserService userService) {
        this.tweetRepository = tweetRepository;
        this.userService = userService;
    }

    @Autowired


    @Override
    public List<Tweet> findAll() {
        //TODO handle exceptions
        return tweetRepository.findAll();
    }

    @Override
    public Tweet find(int id) {
        //TODO handle exceptions
        Optional<Tweet> tweet = tweetRepository.findById(id);
        return tweet.isPresent() ? tweet.get() : null;
    }

    @Override
    public Tweet save(TweetCreateRequest newTweetReq) {
        //TODO handle exceptions
        User user = userService.find(newTweetReq.getUserId());
        if(user == null) {
            return null;
        }
        Tweet toSave = new Tweet();
        toSave.setText(newTweetReq.getText());
        toSave.setImageUrl(newTweetReq.getImageUrl());
        toSave.setUser(user);
        return tweetRepository.save(toSave);
    }

    @Override
    public Tweet delete(int id) {
        //TODO handle exceptions
        Tweet founded = find(id);
        tweetRepository.delete(founded);
        return founded;
    }

    @Override
    public List<Tweet> getAllTweets(Optional<Integer> userId) {
        //TODO handle exceptions
        if (userId.isPresent()) {
            return tweetRepository.findByUserId(userId.get());
        }
        return tweetRepository.findAll();
    }

    @Override
    public Tweet updateOneTweetById(TweetUpdateRequest tweetUpdateRequest, int id) {
        Optional<Tweet> tweet = tweetRepository.findById(id);
        if(tweet.isPresent()) {
            Tweet toUpdate = tweet.get();
            toUpdate.setText(tweetUpdateRequest.getText());
            LocalDateTime updateTime = LocalDateTime.now();
            toUpdate.setUpdatedAt(updateTime);
            tweetRepository.save(toUpdate);
        }
        return null;
    }
}
