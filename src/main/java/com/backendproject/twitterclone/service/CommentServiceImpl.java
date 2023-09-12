package com.backendproject.twitterclone.service;

import com.backendproject.twitterclone.entity.Comment;
import com.backendproject.twitterclone.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
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
    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    @Override
    public Comment update(int id, Comment comment) {
        Optional<Comment> existComment = commentRepository.findById(id);
        if (existComment.isPresent()){
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
}
