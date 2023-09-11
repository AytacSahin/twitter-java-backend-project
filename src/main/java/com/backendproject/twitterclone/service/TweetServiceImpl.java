package com.backendproject.twitterclone.service;

import com.backendproject.twitterclone.entity.Tweet;
import com.backendproject.twitterclone.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TweetServiceImpl implements TweetService{

    private TweetRepository tweetRepository;

    @Autowired
    public TweetServiceImpl(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @Override
    public List<Tweet> findAll() {
        return tweetRepository.findAll();
    }

    @Override
    public Tweet find(int id) {
        Optional<Tweet> tweet = tweetRepository.findById(id);
        return tweet.isPresent() ? tweet.get() : null;
    }

    @Override
    public Tweet save(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    @Override
    public void delete(Tweet tweet) {
        tweetRepository.delete(tweet);
    }
}
