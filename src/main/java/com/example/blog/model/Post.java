package com.example.blog.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Post {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    @Column
    private String anons;

    @Column(length = 500)
    private String fullText;

    @Column
    private Integer views;
}
