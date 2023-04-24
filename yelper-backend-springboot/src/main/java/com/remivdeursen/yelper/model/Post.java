package com.remivdeursen.yelper.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String message;

    @PositiveOrZero
    private int likes;

    @PositiveOrZero
    private int downvotes;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> comments;

    // constructors, getters, and setters

    public Post(Long id, String username, String message, int likes, int upvotes, int downvotes, List<Comment> comments) {
        this.id = id;
        this.username = username;
        this.message = message;
        this.likes = likes;
        this.downvotes = downvotes;
        this.comments = comments;
    }

    public Post() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(int downvotes) {
        this.downvotes = downvotes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
