package com.backendproject.twitterclone.requests;

import lombok.Data;

@Data
public class LikeCreateRequest {
    int userId;
    int tweetId;
}
