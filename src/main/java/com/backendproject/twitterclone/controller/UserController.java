package com.backendproject.twitterclone.controller;

import com.backendproject.twitterclone.entity.User;
import com.backendproject.twitterclone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable int id) {
        return userService.find(id);
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public User save(@RequestBody User user, @PathVariable int id) {
        User founded = findById(id);
        if (founded != null) {
            user.setId(id);
            return userService.save(user);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public User delete(@PathVariable int id) {
        User founded = findById(id);
        userService.delete(founded);
        return founded;
    }
}
