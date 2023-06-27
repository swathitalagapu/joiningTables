package com.example.joiningTables.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "user")

public class User {
    @Id
    private int id;
    @Column
    private String userName;
    @OneToMany(targetEntity = Post.class, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private List<Post> posts;
}
