package com.backendproject.twitterclone.service;

import com.backendproject.twitterclone.entity.Comment;
import com.backendproject.twitterclone.entity.Tweet;
import com.backendproject.twitterclone.entity.User;
import com.backendproject.twitterclone.repository.CommentRepository;
import com.backendproject.twitterclone.requests.CommentCreateRequest;
import com.backendproject.twitterclone.requests.CommentUpdateRequest;
import com.backendproject.twitterclone.responses.CommentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private UserService userService;
    private TweetService tweetService;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, UserService userService, TweetService tweetService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.tweetService = tweetService;
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment find(int id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.isPresent() ? comment.get() : null;
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment update(int id, Comment comment) {
        Optional<Comment> existComment = commentRepository.findById(id);
        if (existComment.isPresent()) {
            Comment foundedComment = existComment.get();
            comment.setId(id);
            return commentRepository.save(foundedComment);
        }
        return null;
    }

    @Override
    public Comment deleteById(int id) {
        Comment founded = find(id);
        commentRepository.delete(founded);
        return founded;
    }

    @Override
    public List<CommentResponse> getAllCommentsWithParam(Optional<Integer> userId, Optional<Integer> tweetId) {
        List<Comment> mappedList;
        if (userId.isPresent() && tweetId.isPresent()) {
            mappedList = commentRepository.findByUserIdAndTweetId(userId.get(), tweetId.get());
        } else if (userId.isPresent()) {
            mappedList = commentRepository.findByUserId(userId.get());
        } else if (tweetId.isPresent()) {
            mappedList = commentRepository.findByTweetId(tweetId.get());
        } else {
            mappedList = commentRepository.findAll();
        }
        return mappedList.stream().map(comment -> {
            return new CommentResponse(comment);
        }).collect(Collectors.toList());
    }

    @Override
    public Comment createOneComment(CommentCreateRequest createRequest) {
        User user = userService.find(createRequest.getUserId());
        Tweet tweet = tweetService.find(createRequest.getTweetId());
        if (user != null && tweet != null) {
            Comment commentToSave = new Comment();
            commentToSave.setText(createRequest.getText());
            commentToSave.setUser(user);
            commentToSave.setTweet(tweet);
            if (createRequest.getImageUrl() != null) {
                commentToSave.setImageUrl(createRequest.getImageUrl());
            }
            return commentRepository.save(commentToSave);
        } else {
            return null;
        }
    }

    @Override
    public Comment updateOneComment(int id, CommentUpdateRequest updateRequest) {
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isPresent()) {
            Comment commentToUpdate = comment.get();
            commentToUpdate.setText(updateRequest.getText());
            return commentRepository.save(commentToUpdate);
        }
        return null;
    }
}
