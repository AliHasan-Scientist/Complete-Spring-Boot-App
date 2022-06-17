package com.backend.myappbackend.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_title", length = 100, nullable = false)
    private Integer postId;
    private String title;
    @Column(length = 10000)
    private String content;
    private String imageName;
    private Date addedDate;
    //
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    //
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
