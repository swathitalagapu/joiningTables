package com.example.joiningTables.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentResponse {

    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;

}
