package com.backendproject.twitterclone.responses;

import com.backendproject.twitterclone.entity.Tweet;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TweetResponse {
    private int id;
    private int userId;
    private String userNick;
    private String text;
    private String imageUrl;
    private int likeCount;
    private int CommentCount;

    public TweetResponse(Tweet entity) {
        this.id = entity.getId(); // tweet
        this.userId = entity.getUser().getId(); // user
        this.userNick = entity.getUser().getNick(); // user
        this.text = entity.getText(); // tweet
        this.imageUrl = entity.getImageUrl(); // tweet
    }
}
