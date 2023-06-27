package com.example.joiningTables.service;

import com.example.joiningTables.dto.CommentResponse;
import com.example.joiningTables.entity.Comment;
import com.example.joiningTables.entity.Post;
import com.example.joiningTables.exception.DataNotFoundException;
import com.example.joiningTables.repository.CommentRepository;
import com.example.joiningTables.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    PostRepository postRepository;
    public Optional<Comment> createComment(int postId, Comment comment){
        Optional<Comment> cmt = postRepository.findById(postId).map(post -> {
//            comment.setPost(post);
            return commentRepository.save(comment);
        });
        return cmt;

    }

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }
    public Comment getCommentsById(int id){
        return commentRepository.findById(id).orElse(null);
    }



    public Comment updateComment(int id, Comment comment){
        Comment cmt = commentRepository.findById(comment.getId()).orElse(null);
        cmt.setId(comment.getId());
        cmt.setName(comment.getName());
        cmt.setBody(comment.getBody());
        cmt.setEmail(comment.getEmail());
        Comment updatedComment = commentRepository.save(cmt);
        return updatedComment;
    }


    public void deleteComment(int id) {
        commentRepository.deleteById(id);
    }

    public List<CommentResponse> getCommentInformation() {
        return commentRepository.getCommentInformation();
    }

    public List<CommentResponse> getCommentssById(int id){
        return commentRepository.getCommentsById(id);
    }

    public CommentResponse getCommentsByID(int id){
        return commentRepository.getCommentById(id);
    }

}
