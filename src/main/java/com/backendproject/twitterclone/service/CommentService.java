package com.backendproject.twitterclone.service;

import com.backendproject.twitterclone.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();
    Comment find(int id);
    Comment save(Comment comment);
    void delete(Comment comment);
    Comment update(int id, Comment comment);
    Comment deleteById(int id);
}
