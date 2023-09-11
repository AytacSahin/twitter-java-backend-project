package com.backendproject.twitterclone.controller;


import com.backendproject.twitterclone.entity.Comment;
import com.backendproject.twitterclone.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> findAll(){
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public Comment findById(@PathVariable int id){
        return commentService.find(id);
    }

    @PostMapping
    public Comment save(@RequestBody Comment comment){
        return commentService.save(comment);
    }

    @PutMapping("/{id}")
    public Comment save(@RequestBody Comment comment, @PathVariable int id ){
        Comment founded = findById(id);
        if (founded != null){
            comment.setId(id);
            return commentService.save(comment);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Comment delete(@PathVariable int id) {
        Comment founded = findById(id);
        commentService.delete(founded);
        return founded;
    }
}
