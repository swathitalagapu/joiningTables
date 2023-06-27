package com.example.joiningTables.repository;

import com.example.joiningTables.dto.CommentResponse;
import com.example.joiningTables.dto.PostResponse;
import com.example.joiningTables.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(int userId);
}
