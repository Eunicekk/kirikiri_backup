package com.example.kirikiri.controller;

import com.example.kirikiri.domain.*;
import com.example.kirikiri.service.ScrapService;
import com.example.kirikiri.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class ScrapController {
    private final ScrapService scrapService;
    private final UserService userService;

    @GetMapping("/activity/scrappedBoard")
    public void getScrappedBoard(Integer page, String userId, Model model, HttpServletRequest request) {
        if(page == null) page = 1;
        boolean userCheck2 = false;
        HttpSession session = request.getSession();
        String sessionUserId = null;

        if(session != null){
            sessionUserId = (String)session.getAttribute("userId");
            if(sessionUserId != null) {
                if (sessionUserId.equals(userId)) userCheck2 = true;
            }
        }

        UserVO userVO = userService.getUserVOById(userId);

        model.addAttribute("userCheck2", userCheck2);
        model.addAttribute("userVO", userVO);
        PageBoardDTO pbt = new PageBoardDTO().createPageBoardDTO(page, 255);
        model.addAttribute("pagination", pbt);
        model.addAttribute("scraps", scrapService.getScrappedBoard(userVO.getUserId(), page));
    }
}