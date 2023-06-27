package com.example.joiningTables.controller;

import com.example.joiningTables.dto.PostResponse;
import com.example.joiningTables.entity.Post;
import com.example.joiningTables.service.PostService;
import com.example.joiningTables.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;

    @PostMapping("/user/{userId}/post")
    public ResponseEntity<Post> createPost(@PathVariable int userId, @RequestBody Post post){
        postService.createPost(userId, post);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @GetMapping("/getPosts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
    @GetMapping("/getPost/{id}")
    public Post findPostsById(@PathVariable int id) {
        return postService.getPostById(id);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable int id, @RequestBody Post post){
       post.setId(id);
       Post pst = postService.updatePost(id, post);
       return new ResponseEntity<>(pst, HttpStatus.OK);
    }


    @DeleteMapping("/deletePost")
    public void deletePost(@PathVariable int id){
         postService.deletePost(id);
    }

    @GetMapping("/getPostInfo")
    public List<PostResponse> getJointPostInfo(){
        return postService.getPostInformation();
    }
    @GetMapping("getPosts/{id}")
    public PostResponse getPostInfoById(@PathVariable int id){
        return postService.getPostsById(id);
    }


}
