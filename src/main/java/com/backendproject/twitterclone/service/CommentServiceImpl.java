package com.backendproject.twitterclone.service;

import com.backendproject.twitterclone.entity.Comment;
import com.backendproject.twitterclone.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> findAll() {
        return null;
    }

    @Override
    public Comment find(int id) {
        return null;
    }

    @Override
    public Comment save(Comment comment) {
        return null;
    }

    @Override
    public void delete(Comment comment) {

    }
}
