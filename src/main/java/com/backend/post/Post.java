package com.backend.post;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Post {
    @Id
    @SequenceGenerator(
            name = "post_id'_sequence",
            sequenceName = "post_id'_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_id'_sequence"
    )
    private Integer id;
    private String title;
    private Date createdAt;

    public Post(){}
    public Post(Integer id , String title, Date createdAt) {
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
