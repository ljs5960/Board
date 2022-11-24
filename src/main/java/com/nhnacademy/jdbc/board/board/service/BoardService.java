package com.nhnacademy.jdbc.board.student.service;

import com.nhnacademy.jdbc.board.student.domain.Post;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface BoardService {
    Optional<Post> getPost();
}
