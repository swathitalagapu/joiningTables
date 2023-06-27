package com.example.joiningTables.controller;

import com.example.joiningTables.dto.CommentResponse;
import com.example.joiningTables.dto.PostResponse;
import com.example.joiningTables.entity.User;
import com.example.joiningTables.repository.UserRepository;
import com.example.joiningTables.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userService.createUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @GetMapping("/getSingleUser/{id}")
    public ResponseEntity<User> getSingleUserDetails(@PathVariable int id) {
        Optional<User> user = userService.getSingleUserDetails(id);
        if(user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUserDetails(@PathVariable int id, @RequestBody User user){
        user.setId(id);
        User user1 = userService.updateUserDetails(id, user);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

}