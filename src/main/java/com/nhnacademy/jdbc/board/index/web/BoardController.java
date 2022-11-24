package com.nhnacademy.jdbc.board.index.web;

import com.nhnacademy.jdbc.board.board.domain.Post;
import com.nhnacademy.jdbc.board.board.service.BoardService;
import com.nhnacademy.jdbc.board.board.service.impl.BoardServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
@Slf4j
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardServiceImpl boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/post")
    public String getPosts() {
        return "post/postList";
    }

    @GetMapping("/post{postId}")
    public String getPost() {
        return "post/post";
    }

    @GetMapping("/post/write")
    public String insertPost() {
        return "post/postForm";
    }

    @PostMapping("/post/write")
    public String insertPost(@RequestParam("title") String title,
                             @RequestParam("content") String content) {
        Post post = new Post(title, content, "testId");

        boardService.insertPost(post);
        return "post/postList";
    }
}
