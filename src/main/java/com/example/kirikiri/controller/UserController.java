package com.example.kirikiri.controller;

import com.example.kirikiri.domain.UserVO;
import com.example.kirikiri.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/myPage/info")
    public void getInfoById(String userId, Model model){
        model.addAttribute("user", userService.getInfo("kevs"));
    }

    @PostMapping("/myPage/info")
    public RedirectView updateInfo(UserVO userVO, RedirectAttributes redirectAttributes){
        if(userVO.getUserAge()==null){
            userVO.setUserAge(0);
        }
        userVO.setUserId("kevs");
        userService.updateInfo(userVO);
        System.out.println(userVO.isUserAgeCheck());
        redirectAttributes.addAttribute("userId", userVO.getUserId());
        return new RedirectView("/myPage/info");
    }
    @GetMapping("/myPage/delete")
    public void delete(){}


    @PostMapping("/myPage/delete")
    public RedirectView delete(String userId){
        userService.deleteInfo("pigs");
        return new RedirectView("/mainPageHtml/index");
    }

}