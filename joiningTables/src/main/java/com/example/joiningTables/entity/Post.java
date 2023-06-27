package com.example.joiningTables.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "post")
public class Post {
    @Id
    private int id;
    @Column
    private String title;
    @Column
    private String body;
    @OneToMany(targetEntity = Comment.class, cascade = CascadeType.ALL)
    @JoinColumn(name="post_id", referencedColumnName = "id")
    private List<Comment> comments;
}
