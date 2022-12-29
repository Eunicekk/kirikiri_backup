package com.example.kirikiri.controller;

import com.example.kirikiri.domain.BoardVO;
import com.example.kirikiri.domain.UserVO;
import com.example.kirikiri.mapper.BoardMapper;
import com.example.kirikiri.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private final String Category = "Counseling";

    @GetMapping("/all")
    public String getList(Model model){
        model.addAttribute("boards", boardService.getListAll());
        return "/community";
    }
    @GetMapping("/new")
    public String addPost(BoardVO boardVO, UserVO userVO){
        userVO.setUserId("aaa");
        userVO.setUserNickname("aaa");
        userVO.setUserNation("Japan");
        boardVO.setNationName(userVO.getUserNation());
        boardVO.setCategoryName(Category);
        boardVO.setUserId(userVO.getUserId());
        return "/addPost";
    }
    @PostMapping("/new")
    public RedirectView addPost(BoardVO boardVO){
        boardService.add(boardVO);
        return new RedirectView("/all");
    }
    @GetMapping("/post")
    public String post(Long boardId, Model model){
        BoardVO boardVO = boardService.getBoard(boardId);
        boolean userCheck;
        if(boardVO.getUserId().equals("aaa")) userCheck = true;
        else userCheck = false;
        model.addAttribute("boardVO", boardVO);
        model.addAttribute("userCheck", userCheck);
        return "/post";
    }
}
