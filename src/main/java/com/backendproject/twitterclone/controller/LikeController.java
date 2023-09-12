package com.backendproject.twitterclone.controller;

import com.backendproject.twitterclone.entity.Like;
import com.backendproject.twitterclone.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like")
public class LikeController {
    private LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }
    @GetMapping
    public List<Like> findAll(){
        return likeService.findAll();
    }

    @GetMapping("/{id}")
    public Like findById(@PathVariable int id){
        return likeService.find(id);
    }

    @PostMapping
    public Like save(@RequestBody Like like){
        return likeService.save(like);
    }

    @PutMapping("/{id}")
    public Like save(@RequestBody Like like, @PathVariable int id ){
        //TODO service layer'ina tasi:
        Like founded = findById(id);
        if (founded != null){
            like.setId(id);
            return likeService.save(like);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Like delete(@PathVariable int id) {
        Like founded = findById(id);
        likeService.delete(founded);
        return founded;
    }
}
