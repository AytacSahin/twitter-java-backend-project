package com.backendproject.twitterclone.service;

import com.backendproject.twitterclone.entity.Comment;
import com.backendproject.twitterclone.requests.CommentCreateRequest;
import com.backendproject.twitterclone.requests.CommentUpdateRequest;
import com.backendproject.twitterclone.responses.CommentResponse;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<Comment> findAll();
    Comment find(int id);
    Comment save(Comment comment);
    Comment update(int id, Comment comment);
    Comment deleteById(int id);
    List<CommentResponse> getAllCommentsWithParam(Optional<Integer> userId, Optional<Integer> postId);
    Comment createOneComment(CommentCreateRequest createRequest);
    Comment updateOneComment(int id, CommentUpdateRequest updateRequest);
}
