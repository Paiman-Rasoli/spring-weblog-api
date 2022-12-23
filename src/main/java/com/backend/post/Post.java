package com.backend.post;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Post {
    @Id
    @SequenceGenerator(
            name = "post_id_sequence",
            sequenceName = "post_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_id_sequence"
    )
    private Integer id;
    private String title;
    private String createdAt;

    public Post(){}
    public Post(Integer id , String title, String createdAt) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
