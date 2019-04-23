package com.github.daanielowsky.FinalProject.entity;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User userCommenting;

    @ManyToOne
    private User commentedUser;

    @Column(nullable = false)
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserCommenting() {
        return userCommenting;
    }

    public void setUserCommenting(User userCommenting) {
        this.userCommenting = userCommenting;
    }

    public User getCommentedUser() {
        return commentedUser;
    }

    public void setCommentedUser(User commentedUser) {
        this.commentedUser = commentedUser;
    }
}
