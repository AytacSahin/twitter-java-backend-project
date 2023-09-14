package com.backendproject.twitterclone.controller;

import com.backendproject.twitterclone.entity.Tweet;
import com.backendproject.twitterclone.requests.TweetCreateRequest;
import com.backendproject.twitterclone.requests.TweetUpdateRequest;
import com.backendproject.twitterclone.responses.TweetResponse;
import com.backendproject.twitterclone.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tweet")
@CrossOrigin(origins = "http://localhost:3000")
public class TweetController {
    private TweetService tweetService;

    @Autowired
    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping
    public List<TweetResponse> getAllTweets(@RequestParam Optional<Integer> userId){
    //  Optional sayesinde userId gelirse -> userId'ye ait, gelmezse tum tweet'ler.
        return tweetService.getAllTweets(userId);
    }

    @GetMapping("/{id}")
    public Tweet findById(@PathVariable int id){
        return tweetService.find(id);
    }

    @PostMapping
    public Tweet createOneTweet(@RequestBody TweetCreateRequest newTweet){
        return tweetService.save(newTweet);
    }

    @PutMapping("/{id}")
    public Tweet updateOneTweet(@RequestBody TweetUpdateRequest tweetUpdateRequest, @PathVariable int id ){
        return tweetService.updateOneTweetById(tweetUpdateRequest, id);
    }

    @DeleteMapping("/{id}")
    public Tweet delete(@PathVariable int id) {
        return tweetService.delete(id);
    }
}
