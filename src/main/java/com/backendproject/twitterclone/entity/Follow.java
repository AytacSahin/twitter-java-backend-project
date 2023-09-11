package com.backendproject.twitterclone.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="follow", schema = "twitter")
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "follow_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
}
