package com.backendproject.twitterclone.responses;

import com.backendproject.twitterclone.entity.Comment;
import com.backendproject.twitterclone.entity.Tweet;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class CommentResponse {
    private int id;
    private int userId;
    private String userName;
    private String userNick;
    private String profilePicture;
    private String text;
    private LocalDateTime updatedAt;
    private String imageUrl;

    public CommentResponse(Comment entity) {
        this.id = entity.getId(); // comment
        this.userId = entity.getUser().getId(); // user
        this.userName = entity.getUser().getName(); // user
        this.userNick = entity.getUser().getNick(); // user
        this.profilePicture = entity.getUser().getProfilePicture();
        this.text = entity.getText(); // comment
        this.updatedAt = entity.getUpdatedAt(); // comment
        this.imageUrl = entity.getImageUrl(); // comment
    }
}
