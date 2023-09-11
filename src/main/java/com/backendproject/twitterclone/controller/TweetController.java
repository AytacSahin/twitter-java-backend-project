package com.backendproject.twitterclone.controller;

import com.backendproject.twitterclone.entity.Tweet;
import com.backendproject.twitterclone.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweet")
public class TweetController {
    private TweetService tweetService;

    @Autowired
    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping
    public List<Tweet> findAll(){
        return tweetService.findAll();
    }

    @GetMapping("/{id}")
    public Tweet findById(@PathVariable int id){
        return tweetService.find(id);
    }

    @PostMapping
    public Tweet save(@RequestBody Tweet tweet){
        return tweetService.save(tweet);
    }

    @PutMapping("/{id}")
    public Tweet save(@RequestBody Tweet tweet, @PathVariable int id ){
        Tweet founded = findById(id);
        if (founded != null){
            tweet.setId(id);
            return tweetService.save(tweet);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Tweet delete(@PathVariable int id) {
        Tweet founded = findById(id);
        tweetService.delete(founded);
        return founded;
    }
}
