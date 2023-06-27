package com.example.joiningTables.controller;

import com.example.joiningTables.dto.CommentResponse;
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

    @GetMapping("/get")
    public List<Comment> getAllComments() {

        return commentService.getAllComments();
    }
    @GetMapping("/get/{id}")
    public Comment findPostsById(@PathVariable int id) {
        return commentService.getCommentsById(id);
    }
    @PutMapping("/comments/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable int id, @RequestBody Comment comment){
        comment.setId(id);
        Comment cmt = commentService.updateComment(id, comment);
        return new ResponseEntity<>(cmt, HttpStatus.OK);
    }
    @DeleteMapping("/deleteComment")
    public void deleteComment(@PathVariable int id){
        commentService.deleteComment(id);
    }

    @GetMapping("/getAllCommentsInfo")
    public List<CommentResponse> getJointCommentsInfo(){
        return commentService.getCommentInformation();
    }

    @GetMapping("getPosts/{id}/Comments")
    public List<CommentResponse> getCommentsInfoByPostId(@PathVariable int id){
        return commentService.getCommentssById(id);
    }

    @GetMapping("getComments/{id}")
    public CommentResponse getCommentInfoByCommentId(@PathVariable int id){
        return commentService.getCommentsByID(id);
    }

}
