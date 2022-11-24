package com.nhnacademy.jdbc.board.student.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private final String id;
    private final String password;
    private final Boolean isAdmin;
}
