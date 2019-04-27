package com.obiew.Controllers;

import com.obiew.Entities.User;
import com.obiew.Repositories.RemoteUserRepository;
import com.obiew.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
    private UserRepository userRepository;
    private RemoteUserRepository remoteUserRepository;

    @Autowired
    public UserController(UserRepository userRepository, RemoteUserRepository remoteUserRepository) {
        this.userRepository = userRepository;
        this.remoteUserRepository = remoteUserRepository;
    }

    @PostMapping("/register")
//    public ResponseEntity<User> register(@RequestBody User user) {
//        if (userRepository.findByUsername(user.getUsername()) != null) {
//            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
//        }
//        user = userRepository.save(user);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
    public ResponseEntity<Boolean> register(@RequestBody User user) {
        return new ResponseEntity<>(remoteUserRepository.register(user), HttpStatus.OK);
    }

    @PostMapping("/login")
//    public ResponseEntity<User> login(@RequestBody User user) {
//        if (user != null) {
//            User storedUser = userRepository.findByUsername(user.getUsername());
//            if (user.equals(storedUser)) {
//                return new ResponseEntity<>(storedUser, HttpStatus.OK);
//            }
//        }
//        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
//    }
    public ResponseEntity<Boolean> login(@RequestBody User user) {
        return new ResponseEntity<>(remoteUserRepository.login(user), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> delete(@RequestBody User user) {
        if (user != null && user.equals(userRepository.findByUsername(user.getUsername()))) {
            userRepository.delete(user);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        User user = userRepository.findByUserId(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
    }
}
