package com.techspine.crs.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String review;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User User;
    private LocalDateTime createdAt;

    public Reviews() {
    }

    public Reviews(long id, String review, User User, LocalDateTime createdAt) {
        this.id = id;
        this.review = review;
        this.User = User;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public User getuser() {
        return User;
    }

    public void setuser(User User) {
        this.User = User;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
