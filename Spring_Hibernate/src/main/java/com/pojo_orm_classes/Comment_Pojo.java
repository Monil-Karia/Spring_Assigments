package com.pojo_orm_classes;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment_Pojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_at")
    private java.util.Date createdAt;

    @Column(name = "updated_at")
    private java.util.Date updatedAt;

    @Column(name = "text", columnDefinition = "LONGTEXT")
    private String text;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post_Pojo post;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.util.Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.util.Date createdAt) {
        this.createdAt = createdAt;
    }

    public java.util.Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(java.util.Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Post_Pojo getPost() {
        return post;
    }

    public void setPost(Post_Pojo post) {
        this.post = post;
    }
}
