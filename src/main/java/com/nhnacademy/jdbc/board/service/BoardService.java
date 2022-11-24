package com.nhnacademy.jdbc.board.service;

import com.nhnacademy.jdbc.board.domain.Post;
import java.util.List;

public interface BoardService {
    List<Post> getPosts();
//
//    Optional<Post> getPost(Long id);

    void insertPost(Post post);
}
