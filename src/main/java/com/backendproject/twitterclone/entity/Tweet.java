package com.backendproject.twitterclone.entity;

import com.backendproject.twitterclone.helpers.TimeDateFn;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "FieldHandler"})
@Table(name="tweet", schema = "twitter")

public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tweet_id")
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Tweet(String text, String imageUrl, User user) {
        this.text = text;
        this.imageUrl = imageUrl;
        this.user = user;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PrePersist
    public void onPrePersist() {
        this.createdAt = TimeDateFn.TimeCalculator();
        this.updatedAt = TimeDateFn.TimeCalculator();
    }

    @PreUpdate
    public void onPreUpdate() {
        this.updatedAt = TimeDateFn.TimeCalculator();
    }
}
