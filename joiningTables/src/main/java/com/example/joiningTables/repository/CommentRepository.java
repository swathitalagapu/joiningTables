package com.example.joiningTables.repository;

import com.example.joiningTables.dto.CommentResponse;
import com.example.joiningTables.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query("SELECT new com.example.joiningTables.dto.CommentResponse(p.id,c.id,c.name,c.email,c.body) FROM Post p JOIN p.comments c")
    public List<CommentResponse> getCommentInformation();
    @Query("SELECT new com.example.joiningTables.dto.CommentResponse(p.id,c.id,c.name,c.email,c.body) FROM Post p JOIN p.comments c where p.id =:id")
    public List<CommentResponse> getCommentsById(@Param("id") int id);

    @Query("SELECT new com.example.joiningTables.dto.CommentResponse(p.id,c.id,c.name,c.email,c.body) FROM Post p JOIN p.comments c where c.id =:id")
    public CommentResponse getCommentById(@Param("id") int id);
}
