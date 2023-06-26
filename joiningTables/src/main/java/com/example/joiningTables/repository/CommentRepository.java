package com.example.joiningTables.repository;

import com.example.joiningTables.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByPostId(int postId);

    List<Comment> deleteByPostId(int postId);
}
