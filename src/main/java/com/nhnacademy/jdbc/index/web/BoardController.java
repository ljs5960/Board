package com.nhnacademy.jdbc.index.web;

import com.nhnacademy.jdbc.board.domain.Comment;
import com.nhnacademy.jdbc.board.domain.Post;
import com.nhnacademy.jdbc.board.service.BoardService;
import com.nhnacademy.jdbc.board.service.impl.BoardServiceImpl;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardServiceImpl boardService) {
        this.boardService = boardService;
    }

    String LOGIN_SESSION_KEY = "LOGIN_SESSION";

    @GetMapping()
    public String getPosts(HttpSession session, ModelMap modelMap) {
        List<Post> posts = boardService.getPosts();
        modelMap.put("posts", posts);

        return "post/postList";
    }

    @GetMapping("/{postId}")
    public String getPost(@PathVariable("postId") Long postId, HttpSession session, ModelMap modelMap) {
        Post post = boardService.getPostById(postId);
        List<Comment> comments = boardService.getCommentByPostId(postId);

        modelMap.addAttribute("post", post);
        modelMap.addAttribute("comments", comments);

        if (Objects.nonNull(session.getAttribute(LOGIN_SESSION_KEY))) {
            return "post/postView";
        }

        return "post/postViewNoComment";
    }

    @GetMapping("/write")
    public String insertPost(HttpSession session) {
        if (Objects.nonNull(session.getAttribute(LOGIN_SESSION_KEY))) {
            return "post/postForm";
        }
        return "redirect:/login";
    }

    @PostMapping("/write")
    public String insertPost(@RequestParam("title") String title,
                             @RequestParam("content") String content,
                             HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute(LOGIN_SESSION_KEY);
        String userId = boardService.getIdByName(userName);
        Post post = new Post(title, content, userName);
        boardService.insertPost(post);

        return "redirect:/board";
    }

    @GetMapping("/update/{postId}")
    public String updatePost(@PathVariable("postId") Long postId, ModelMap modelMap) {
        Post post = boardService.getPostById(postId);
        modelMap.addAttribute("post", post);

        return "post/postUpdateForm";
    }

    @PostMapping("/update/{postId}")
    public String updatePost(@RequestParam("title") String title,
                             @RequestParam("content") String content,
                             @PathVariable("postId") Long postId,
                             HttpSession session) {
        String modifierId = (String) session.getAttribute(LOGIN_SESSION_KEY);

        Post post = new Post(postId, title, content, modifierId);
        boardService.updatePost(post);

        return "redirect:/board/{postId}";
    }

    @GetMapping("/delete/{postId}")
    public String deletePost(@PathVariable("postId") Long postId) {
        boardService.deletePost(postId);

        return "redirect:/board";
    }

    @PostMapping("/comment/{postId}")
    public String insertComment(@RequestParam("content")String content,
                                @PathVariable("postId")Long postId,
                                HttpSession session) {
        String userId = (String) session.getAttribute(LOGIN_SESSION_KEY);

        Comment comment = new Comment(content, userId, postId);

        boardService.insertComment(comment);

        return "redirect:/board/{postId}";
    }
}
