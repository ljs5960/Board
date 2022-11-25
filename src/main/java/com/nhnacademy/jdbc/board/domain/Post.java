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
    private Long userId;
    private String modifierId;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Boolean isDeleted;
    private Long parentPostId;

    public Post(String title, String content, Long userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public Post(Long id, String title, String content, String modifierId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.modifierId = modifierId;
    }
}
