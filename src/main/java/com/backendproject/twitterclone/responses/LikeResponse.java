package com.backendproject.twitterclone.responses;

import com.backendproject.twitterclone.entity.Like;
import lombok.Data;

@Data
public class LikeResponse {

    int id;
    int userId;
    int tweetId;

    public LikeResponse(Like entity) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.tweetId = entity.getTweet().getId();
    }
}
