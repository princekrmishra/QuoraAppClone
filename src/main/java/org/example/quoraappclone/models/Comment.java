package org.example.quoraappclone.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Comment extends BaseModel {

    private String content;

    // The user who wrote this comment
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // The answer on which this comment was made
    @ManyToOne
    @JoinColumn(name = "answer_id", nullable = false)
    private Answer answer;

    // Used when this comment is a reply to another comment
    @ManyToOne
    @JoinColumn(name = "parent_comment_id")
    private Comment parentComment;

    // One comment can have many replies
    @OneToMany(mappedBy = "parentComment")
    private Set<Comment> replies;

    // Many users can like many comments
    @ManyToMany
    @JoinTable(
            name = "comment_likes",
            joinColumns = @JoinColumn(name = "comment_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> likedBy;
}