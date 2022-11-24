package com.nhnacademy.jdbc.index.web;

import com.nhnacademy.jdbc.board.domain.Post;
import com.nhnacademy.jdbc.board.service.BoardService;
import com.nhnacademy.jdbc.board.service.impl.BoardServiceImpl;
import java.net.http.HttpRequest;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @GetMapping("/write")
    public String insertPost() {
        return "post/postForm";
    }

    @PostMapping("/write")
    public String insertPost(@RequestParam("title") String title,
                             @RequestParam("content") String content,
                             HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("LOGIN_SESSION");

        Post post = new Post(title, content, userId);
        boardService.insertPost(post);

        return "redirect:/";
    }
}
