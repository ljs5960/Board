package com.nhnacademy.jdbc.board.service;

import com.nhnacademy.jdbc.board.domain.Post;
import java.util.List;

public interface BoardService {
    List<Post> getPosts();

    Post getPostById(Long postId);

    void insertPost(Post post);
}
