package com.nhnacademy.jdbc.board.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Comment {
    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private String userId;
    private Long postId;

    public Comment(String content, String userId, Long postId) {
        this.content = content;
        this.userId = userId;
        this.postId = postId;
    }
}

