package com.nhnacademy.jdbc.board.board.service.impl;

import com.nhnacademy.jdbc.board.board.domain.Post;
import com.nhnacademy.jdbc.board.board.mapper.BoardMapper;
import com.nhnacademy.jdbc.board.board.service.BoardService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public List<Post> getPosts() {
        return boardMapper.selectPosts();
    }

//


    @Override
//    @Transactional
    public void insertPost(Post post) {
        boardMapper.insertPost(post);
    }
}
