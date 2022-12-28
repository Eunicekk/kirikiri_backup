package com.example.kirikiri.controller;


import com.example.kirikiri.domain.PageBoardDTO;
import com.example.kirikiri.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;


//    작성한 게시글 조회
    @GetMapping("/activity")
    public void getWrittenBoard(String userId, Integer page, Model model){
        model.addAttribute("pagination", new PageBoardDTO().createPageBoardDTO(1, 167));
        model.addAttribute("boards", boardService.getWrittenBoard("kevs",1));
    }
}
