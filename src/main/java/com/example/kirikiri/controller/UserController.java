package com.example.kirikiri.controller;

import com.example.kirikiri.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/myPage")
    public void getInfoById(String userId, Model model){
        model.addAttribute("user", userService.getInfo("kevs"));
    }

}