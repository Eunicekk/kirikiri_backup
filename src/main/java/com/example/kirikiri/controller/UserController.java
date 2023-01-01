package com.example.kirikiri.controller;

import com.example.kirikiri.domain.UserVO;
import com.example.kirikiri.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/signup")
    public String signup(UserVO userVO){
        return "/signup";
    }
    @PostMapping("/signup")
    public String signupComplete(UserVO userVO){
        userService.signup(userVO);
        return "/login";
    }


    @GetMapping("/login")
    public String login(UserVO userVO){
        return "/login";
    }
    @PostMapping("/login")
    public String login(UserVO userVO, Model model, HttpServletRequest request){
        boolean userCheck = true;
        HttpSession session = request.getSession();
        userCheck = (userService.login(userVO) == null) ? true : false;
        model.addAttribute("userCheck", userCheck);
        if(!userCheck) {
            String userId = userVO.getUserId();
            session.setAttribute("userId", userId);
            return "/mainPageHTML/index";
        }
        else return "/login";
    }
}
