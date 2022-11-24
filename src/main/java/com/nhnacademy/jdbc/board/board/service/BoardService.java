package com.nhnacademy.jdbc.board.board.service;

import com.nhnacademy.jdbc.board.board.domain.Post;
import java.util.List;
import java.util.Optional;

public interface BoardService {
//    List<Post> getPosts();
//
//    Optional<Post> getPost(Long id);

    void insertPost(Post post);
}
