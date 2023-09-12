package com.backendproject.twitterclone.requests;

import lombok.Data;

@Data
public class LikeCreateRequest {
    int id;
    int userId;
    int tweetId;
}
