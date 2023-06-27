package com.example.joiningTables.repository;

import com.example.joiningTables.dto.PostResponse;
import com.example.joiningTables.entity.Post;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query("SELECT new com.example.joiningTables.dto.PostResponse(u.id,p.id,p.title,p.body) FROM User u JOIN u.posts p")
    public List<PostResponse> getPostInformation();

    @Query("SELECT new com.example.joiningTables.dto.PostResponse(u.id,p.id,p.title,p.body) FROM User u JOIN u.posts p where p.id =:id")
    public PostResponse getPostById(@Param("id") int id);

}
