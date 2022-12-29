package com.example.kirikiri.controller;


import com.example.kirikiri.domain.PageBoardDTO;
import com.example.kirikiri.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {
    private final BoardService boardService;


//    작성한 게시글 조회
    @GetMapping("/activity")
    public void getWrittenBoard(String userId, Integer page, Model model){
        PageBoardDTO pbt = new PageBoardDTO().createPageBoardDTO(page,255);
        log.info(pbt.toString());
        model.addAttribute("pagination", pbt);
        model.addAttribute("boards", boardService.getWrittenBoard("kevs",pbt.getPage()));
    }

}
