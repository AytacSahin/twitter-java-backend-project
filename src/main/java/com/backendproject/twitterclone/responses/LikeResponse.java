package com.backendproject.twitterclone.responses;

import com.backendproject.twitterclone.entity.Like;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LikeResponse {

    int userId;
    int postId;

    public LikeResponse(Like entity) {
        this.userId = entity.getUser().getId();
        this.postId = entity.getTweet().getId();
    }
}
