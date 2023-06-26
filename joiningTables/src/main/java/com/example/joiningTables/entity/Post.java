package com.example.joiningTables.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String title;
    @Column
    private String body;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
//    @OneToMany(cascade =  CascadeType.ALL, mappedBy = "post")
//    private List<Comment> comments;
}
