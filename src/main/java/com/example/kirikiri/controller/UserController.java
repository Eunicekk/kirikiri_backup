package com.example.kirikiri.controller;

import com.example.kirikiri.domain.UserVO;
import com.example.kirikiri.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.FileInfo;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;


@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/signup")
    public String signup(UserVO userVO){
        return "/signup";
    }
    @PostMapping("/signup")
    public RedirectView signupComplete(UserVO userVO){
        userService.signup(userVO);
        return new RedirectView("/login");
    }


    @GetMapping("/login")
    public String login(UserVO userVO){
        return "/login";
    }
    @PostMapping("/login")
    public RedirectView login(UserVO userVO, Model model, HttpServletRequest request){
        boolean userCheck = true;
        HttpSession session = request.getSession();
        userCheck = (userService.login(userVO) == null) ? true : false;
        model.addAttribute("userCheck", userCheck);
        if(!userCheck) {
            String userId = userVO.getUserId();
            session.setAttribute("userId", userId);
            return new RedirectView("/");
        }
        else return new RedirectView("/login");
    }

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
