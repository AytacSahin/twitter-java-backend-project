package com.backendproject.twitterclone.service;

import com.backendproject.twitterclone.entity.Like;

import java.util.List;

public interface LikeService {
    List<Like> findAll();
    Like find(int id);
    Like save(Like like);
    void delete(Like like);
}
