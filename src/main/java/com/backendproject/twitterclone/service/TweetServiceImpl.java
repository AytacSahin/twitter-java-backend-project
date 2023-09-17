package com.backendproject.twitterclone.service;

import com.backendproject.twitterclone.entity.Tweet;
import com.backendproject.twitterclone.entity.User;
import com.backendproject.twitterclone.repository.TweetRepository;
import com.backendproject.twitterclone.requests.TweetCreateRequest;
import com.backendproject.twitterclone.requests.TweetUpdateRequest;
import com.backendproject.twitterclone.responses.LikeResponse;
import com.backendproject.twitterclone.responses.TweetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TweetServiceImpl implements TweetService{

    private TweetRepository tweetRepository;
    private UserService userService;
    private LikeService likeService;

    @Autowired
    public TweetServiceImpl(TweetRepository tweetRepository, UserService userService, @Lazy LikeService likeService) {
        this.tweetRepository = tweetRepository;
        this.userService = userService;
        this.likeService = likeService;
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
    public List<TweetResponse> getAllTweets(Optional<Integer> userId) {
        // TODO handle exceptions
        List<Tweet> mappedList;
        if (userId.isPresent()) {
            mappedList = tweetRepository.findByUserId(userId.get());
        } else {
            mappedList = tweetRepository.findAll();
        }
        Collections.sort(mappedList, Comparator.comparing(Tweet::getUpdatedAt).reversed());
        return mappedList.stream().map(p-> {
                List<LikeResponse> likesIn = likeService.getAllLikesWithParam(Optional.empty(), Optional.of(p.getId()));
                return new TweetResponse(p, likesIn);})
                .collect(Collectors.toList());
    }

//    @Override
//    public List<TweetResponse> getAllTweets(Optional<Integer> userId) {
//        // TODO handle exceptions
//        List<Tweet> mappedList;
//        if (userId.isPresent()) {
//            mappedList = tweetRepository.findByUserId(userId.get());
//        } else {
//            mappedList = tweetRepository.findAll();
//        }
//        List<TweetResponse> tweetResponses = mappedList.stream()
//                .map(p-> new TweetResponse(p)).collect(Collectors.toList());
//        for (TweetResponse tweetResponse: tweetResponses) {
//            int tweetId = tweetResponse.getId();
//            int commentCount = commentService.getAllCommentsWithParam(Optional.empty(), Optional.of(tweetId)).size();
//            int likeCount = likeService.getAllLikesWithParam(Optional.empty(), Optional.of(tweetId)).size();
//            tweetResponse.setCommentCount(commentCount);
//            tweetResponse.setLikeCount(likeCount);
//        }
//        return tweetResponses;
//    }

    @Override
    public Tweet updateOneTweetById(TweetUpdateRequest tweetUpdateRequest, int id) {
        Optional<Tweet> tweet = tweetRepository.findById(id);
        if(tweet.isPresent()) {
            Tweet toUpdate = tweet.get();
            toUpdate.setText(tweetUpdateRequest.getText());
            LocalDateTime updateTime = LocalDateTime.now();
            toUpdate.setUpdatedAt(updateTime);
            tweetRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    @Override
    public void delete(int id) {
        //TODO handle exceptions
        tweetRepository.deleteById(id);
    }
}
