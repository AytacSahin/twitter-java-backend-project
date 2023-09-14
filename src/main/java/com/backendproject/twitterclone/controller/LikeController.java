package com.backendproject.twitterclone.controller;

import com.backendproject.twitterclone.entity.Like;
import com.backendproject.twitterclone.requests.LikeCreateRequest;
import com.backendproject.twitterclone.responses.LikeResponse;
import com.backendproject.twitterclone.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/like")
@CrossOrigin(origins = "http://localhost:3000")
public class LikeController {
    private LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }
    @GetMapping
    public List<LikeResponse> getAllLikes(@RequestParam Optional<Integer> userId,
                                          @RequestParam Optional<Integer> tweetId) {
        return likeService.getAllLikesWithParam(userId, tweetId);
    }
    @GetMapping("/{id}")
    public Like getOneLike(@PathVariable int id) {
        return likeService.find(id);
    }
    @PostMapping
    public Like createOneLike(@RequestBody LikeCreateRequest request) {
        return likeService.createOneLike(request);
    }
    @DeleteMapping("/{id}")
    public void deleteOneLike(@PathVariable int id) {
        likeService.delete(id);
    }
}
