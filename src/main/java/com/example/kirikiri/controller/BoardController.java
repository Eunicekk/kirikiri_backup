package com.example.kirikiri.controller;

import com.example.kirikiri.domain.BoardVO;
import com.example.kirikiri.domain.PageBoardDTO;
import com.example.kirikiri.domain.UserVO;
import com.example.kirikiri.mapper.BoardMapper;
import com.example.kirikiri.service.BoardService;
import jdk.jfr.Category;
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
    private final String free = "Free";
    private final String counseling = "Counseling";
    private final String play = "Play";
    private final String job = "Job";

    @GetMapping("/all")
    public String getList(Model model){
        model.addAttribute("boards", boardService.getListAll());
        return "/community";
    }
    @GetMapping("/free")
    public String freeCategory(Model model){
        model.addAttribute("boards", boardService.getListByCategory(free));
        return "/community";
    }
    @GetMapping("/counseling")
    public String counselingCategory(Model model){
        model.addAttribute("boards", boardService.getListByCategory(counseling));
        return "/community";
    }
    @GetMapping("/play")
    public String playCategory(Model model){
        model.addAttribute("boards", boardService.getListByCategory(play));
        return "/community";
    }
    @GetMapping("/job")
    public String jobCategory(Model model){
        model.addAttribute("boards", boardService.getListByCategory(job));
        return "/community";
    }


    @GetMapping("/new")
    public String addPost(BoardVO boardVO, UserVO userVO){
        userVO.setUserId("aaa");
        userVO.setUserNickname("aaa");
        userVO.setUserNation("Japan");
        boardVO.setNationName(userVO.getUserNation());
        boardVO.setCategoryName("Counselling");
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

    //    작성한 게시글 조회
    @GetMapping("/activity/writtenBoard")
    public void getWrittenBoard(String userId, Integer page, Model model){
        PageBoardDTO pbt = new PageBoardDTO().createPageBoardDTO(page,255);
        model.addAttribute("pagination", pbt);
        model.addAttribute("boards", boardService.getWrittenBoard("kevs",pbt.getPage()));
    }

    @GetMapping("/activity/comment")
    public void getComment(){}
}
