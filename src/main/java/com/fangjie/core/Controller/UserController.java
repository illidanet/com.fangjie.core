package com.fangjie.core.Controller;

import com.fangjie.core.Repository.UserRepository;
import com.fangjie.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping
    public User insertUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("{id}")
    public Optional<User> getUserId(@PathVariable long id) {
        return userRepository.findById(id);
    }


}
