package com.backend.myappbackend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "catergories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    @Column(name = "Title", nullable = false, length = 100)
    private String categoryTitle;
    @Column(name = "Description", nullable = false, length = 300)
    private String categoryDescription;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();
}