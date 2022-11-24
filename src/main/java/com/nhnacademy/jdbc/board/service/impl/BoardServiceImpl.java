package com.nhnacademy.jdbc.board.service.impl;

import com.nhnacademy.jdbc.board.domain.Post;
import com.nhnacademy.jdbc.board.mapper.BoardMapper;
import com.nhnacademy.jdbc.board.service.BoardService;
import java.util.List;
import org.springframework.stereotype.Service;

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
