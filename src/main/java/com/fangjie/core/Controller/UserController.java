package com.fangjie.core.Controller;

import com.fangjie.core.Repository.UserRepository;
import com.fangjie.core.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    private final PasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepository userRepository, PasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping
    public User insertUser(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @GetMapping("{id}")
    public Optional<User> getUserId(@PathVariable long id) {
        return userRepository.findById(id);
    }

    @PostMapping("/register")
    public String register() {
        return "testRegister";
    }

}
