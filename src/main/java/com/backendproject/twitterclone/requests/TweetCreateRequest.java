package com.backendproject.twitterclone.requests;

import lombok.Data;

@Data
public class TweetCreateRequest {
    String text;
    String imageUrl;
    int userId;
}
