package com.backendproject.twitterclone.responses;

import com.backendproject.twitterclone.entity.Like;
import com.backendproject.twitterclone.entity.Tweet;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TweetResponse {
    private int id;
    private int userId;
    private String userName;
    private String userNick;
    private String text;
    private String imageUrl;
    private int likeCount;
    private int CommentCount;
    List<LikeResponse> tweedLikes;

    public TweetResponse(Tweet entity, List<LikeResponse> likes) {
        this.id = entity.getId(); // tweet
        this.userId = entity.getUser().getId(); // user
        this.userName = entity.getUser().getName(); // user
        this.userNick = entity.getUser().getNick(); // user
        this.text = entity.getText(); // tweet
        this.imageUrl = entity.getImageUrl(); // tweet
        this.tweedLikes = likes;
    }
}
