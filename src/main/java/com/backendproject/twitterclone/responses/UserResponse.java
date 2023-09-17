package com.backendproject.twitterclone.responses;

import com.backendproject.twitterclone.entity.Tweet;
import com.backendproject.twitterclone.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class UserResponse {
    private int userId;
    private String userName;
    private String userNick;
    private String profilePicture;

    public UserResponse(User entity) {
        this.userId = entity.getId(); // user
        this.userName = entity.getName(); // user
        this.userNick = entity.getNick(); // user
        this.profilePicture = entity.getProfilePicture();
    }
}