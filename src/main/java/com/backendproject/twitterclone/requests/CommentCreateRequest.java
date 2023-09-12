package com.backendproject.twitterclone.requests;

import lombok.Data;

@Data
public class CommentCreateRequest {
    String text;
    int userId;
    int tweetId;
}
