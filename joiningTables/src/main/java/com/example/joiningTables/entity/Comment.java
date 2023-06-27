package com.example.joiningTables.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
@Table(name = "comment")
public class Comment {

    @Id
    private int id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String body;
}
