package com.example.joiningTables.controller;

import com.example.joiningTables.entity.Comment;
import com.example.joiningTables.entity.Post;
import com.example.joiningTables.service.CommentService;
import com.example.joiningTables.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;
    @PostMapping("/post/{postId}/comment")
    public ResponseEntity<Comment> createComment(@PathVariable int postId, @RequestBody Comment comment){
        commentService.createComment(postId, comment);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @GetMapping("/post/{postId}/comments")
    public List<Comment> getAllCommentsByPostId(@PathVariable int postId){
        return commentService.getAllCommentsByPostId(postId);
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable int id, @RequestBody Comment comment){
        comment.setId(id);
        Comment cmt = commentService.updateComment(id, comment);
        return new ResponseEntity<>(cmt, HttpStatus.OK);
    }
    @DeleteMapping("/post/{postId}/comments")
    public List<Comment> deleteAllCommentsOfPost(@PathVariable int postId){
        return commentService.deleteAllCommentsOfPost(postId);
    }

    @DeleteMapping("/deleteComment")
    public void deleteComment(@PathVariable int id){
        postService.deletePost(id);
    }


}
