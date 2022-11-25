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
    private String userName;
    private String modifierName;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Boolean isDeleted;
    private Long parentPostId;

    public Post(String title, String content, String userName) {
        this.title = title;
        this.content = content;
        this.userName = userName;
    }

    public Post(Long id, String title, String content, String modifierName) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.modifierName = modifierName;
    }
}
