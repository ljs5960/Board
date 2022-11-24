package com.nhnacademy.jdbc.index.web;

import com.nhnacademy.jdbc.board.domain.Post;
import com.nhnacademy.jdbc.board.service.BoardService;
import com.nhnacademy.jdbc.board.service.impl.BoardServiceImpl;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
@Slf4j
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardServiceImpl boardService) {
        this.boardService = boardService;
    }

    @GetMapping()
    public String getPosts(ModelMap modelMap) {
        List<Post> posts = boardService.getPosts();
        modelMap.put("posts", posts);

        return "post/postList";
    }

//    @GetMapping("/{postId}")
//    public String getPost() {
//        return "post/post";
//    }

    @GetMapping("/write")
    public String insertPost() {
        return "post/postForm";
    }

    @PostMapping("/write")
    public String insertPost(@RequestParam("title") String title,
                             @RequestParam("content") String content,
                             @CookieValue(value = "SESSION_VALUE", required = false) String userId) {
        Post post = new Post(title, content, "testId");
        boardService.insertPost(post);

        return "redirect:/";
    }
}
