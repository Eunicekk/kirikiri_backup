package com.example.kirikiri.controller;

import com.example.kirikiri.domain.PageBoardDTO;
import com.example.kirikiri.domain.ScrapDTO;
import com.example.kirikiri.domain.ScrapVO;
import com.example.kirikiri.domain.UserVO;
import com.example.kirikiri.service.ScrapService;
import com.example.kirikiri.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ScrapController {
    private final ScrapService scrapService;
    private final UserService userService;

    @GetMapping("/activity/scrappedBoard")
    public void getScrappedBoard(UserVO userVO, Integer page, Model model) {
        userVO = userService.getUserVOById(userVO.getUserId());
        if(page == null) page = 1;
        PageBoardDTO pbt = new PageBoardDTO().createPageBoardDTO(page, 255);
        model.addAttribute("pagination", pbt);
        model.addAttribute("scraps", scrapService.getScrappedBoard(userVO.getUserId(), page));
    }
}