package com.backendproject.twitterclone.controller;

import com.backendproject.twitterclone.entity.Comment;
import com.backendproject.twitterclone.requests.CommentCreateRequest;
import com.backendproject.twitterclone.requests.CommentUpdateRequest;
import com.backendproject.twitterclone.responses.CommentResponse;
import com.backendproject.twitterclone.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = "http://localhost:3000")
public class CommentController {
    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<CommentResponse> getAllComments(@RequestParam Optional<Integer> userId, @RequestParam Optional<Integer> tweetId){
        return commentService.getAllCommentsWithParam(userId, tweetId);
    }

    @GetMapping("/{commentId}")
    public Comment findById(@PathVariable int commentId){
        return commentService.find(commentId);
    }

    @PostMapping
    public Comment save(@RequestBody CommentCreateRequest createRequest){
        return commentService.createOneComment(createRequest);
    }

    @PutMapping("/{commentId}")
    public Comment save(@RequestBody CommentUpdateRequest updateRequest, @PathVariable int commentId ){
        return commentService.updateOneComment(commentId, updateRequest);
    }

    @DeleteMapping("/{commentId}")
    public Comment delete(@PathVariable int commentId) {
        return commentService.deleteById(commentId);
    }
}
