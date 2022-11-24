package com.nhnacademy.jdbc.board.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post {
    private Long id;
    private String title;
    private String content;
    private Long fileId;
    private String userId;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Boolean isDeleted;
    private Long parentPostId;

    public Post(String title, String userId) {
        this.title = title;
        this.userId = userId;
    }

    public Post(String title, String content, String userId) {
        this(title, userId);
        this.content = content;
    }
}
