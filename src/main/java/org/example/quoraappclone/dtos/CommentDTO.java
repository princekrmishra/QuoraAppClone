package org.example.quoraappclone.dtos;

import lombok.Data;

import java.util.Set;

@Data
public class CommentDTO {
    private Long id;
    private String content;
    private Long userId;
    private String username;
    private Long answerId;
    private Long parentCommentId;
}