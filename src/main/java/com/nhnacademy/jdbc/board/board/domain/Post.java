package com.nhnacademy.jdbc.board.student.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post {
    private final Long id;
    private final String title;
    private final String content;
    private final Long fileId;
    private final Long userId;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final Boolean isDeleted;
    private final Long parentPostId;
}
