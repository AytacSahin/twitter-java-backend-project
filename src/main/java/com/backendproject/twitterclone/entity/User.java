package com.backendproject.twitterclone.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "twitter")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "nick")
    private String nick;

    @Column(name = "password")
    private String password;

//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private List<Tweet> tweets;
//
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private List<Comment> comments;
//
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private List<Like> likes;
}
