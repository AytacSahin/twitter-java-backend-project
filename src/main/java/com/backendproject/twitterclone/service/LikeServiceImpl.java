package com.backendproject.twitterclone.service;

import com.backendproject.twitterclone.entity.Like;
import com.backendproject.twitterclone.entity.Tweet;
import com.backendproject.twitterclone.entity.User;
import com.backendproject.twitterclone.repository.LikeRepository;
import com.backendproject.twitterclone.requests.LikeCreateRequest;
import com.backendproject.twitterclone.responses.LikeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LikeServiceImpl implements LikeService {

    private LikeRepository likeRepository;
    private UserService userService;
    private TweetService tweetService;

    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository, UserService userService, TweetService tweetService) {
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.tweetService = tweetService;
    }

    @Override
    public List<LikeResponse> getAllLikesWithParam(Optional<Integer> userId, Optional<Integer> tweetId) {
        List<Like> list;
        if (userId.isPresent() && tweetId.isPresent()) {
            list = likeRepository.findByUserIdAndTweetId(userId.get(), tweetId.get());
        } else if (userId.isPresent()) {
            list = likeRepository.findByUserId(userId.get());
        } else if (tweetId.isPresent()) {
            list = likeRepository.findByTweetId(tweetId.get());
        } else
            list = likeRepository.findAll();
        return list.stream().map(like -> new LikeResponse(like)).collect(Collectors.toList());
    }

    @Override
    public Like find(int id) {
        return likeRepository.findById(id).orElse(null);
    }

    @Override
    public Like createOneLike(LikeCreateRequest request) {
        System.out.println(request.getUserId());
        System.out.println(request.getTweetId());
        User user = userService.find(request.getUserId());
        Tweet tweet = tweetService.find(request.getTweetId());
        if (user != null && tweet != null && !likeRepository.existsByUserIdAndTweetId(request.getUserId(), request.getTweetId())) {
            Like likeToSave = new Like();
            likeToSave.setTweet(tweet);
            likeToSave.setUser(user);
            return likeRepository.save(likeToSave);
        } else
            return null;
    }

    @Override
    public void delete(int id) {

        //TODO handle exceptions
//        Optional<User> user = userRepository.findById(id);
//        return user.isPresent() ? user.get() : null;

        Optional<Like> like = likeRepository.findById(id);
        if (like.isPresent()) {
            likeRepository.deleteById(id);
        }
        else {
            //TODO exceptions
            System.out.println("Böyle bir like yok....");
        }
    }
}


