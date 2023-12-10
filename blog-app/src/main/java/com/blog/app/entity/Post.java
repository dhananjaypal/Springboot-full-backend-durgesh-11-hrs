package com.blog.app.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int post_id;

    @Column(name = "post_title", length = 100, nullable = false)
    private String title;

    @Column(name = "content", length = 100, nullable = false)
    private String content;

    @Column(name = "image_url", length = 1000)
    private String imageName;

    @Column(name = "added_date")
    private Date addedDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    private User user;
}
