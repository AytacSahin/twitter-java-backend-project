package com.backendproject.twitterclone.service;

import com.backendproject.twitterclone.entity.Like;
import com.backendproject.twitterclone.requests.LikeCreateRequest;
import com.backendproject.twitterclone.responses.LikeResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface LikeService {
    Like find(int id);
    void delete(int id);
    List<LikeResponse> getAllLikesWithParam(Optional<Integer> userId, Optional<Integer> tweetId);
    Like createOneLike(LikeCreateRequest request);
}

