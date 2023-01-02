package com.example.kirikiri.controller;

import com.example.kirikiri.domain.UserVO;
import com.example.kirikiri.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/*")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/main")
    public String main(){
        return "/mainPageHtml/index";
    }

    @GetMapping("/findAccount")
    public void findGet(Model model){

    }

    //계정 찾기
    @PostMapping("/checkEmail")
    public void findById(Model model, String userEmail){
        model.addAttribute("userId", userService.findById(userEmail));
    }
    
    //비밀번호 변경
    @PostMapping("/password")
    public void changePw(Model model, String userId){
        model.addAttribute("user", userService.getUser(userId));
    }


    @PostMapping("/passwordResetCompletion")
    public String changePwCompletion(Model model, String userId, String oldPw, String userPassword){
        UserVO userVO = userService.getUser(userId);

        if (oldPw.equals(userVO.getUserPassword())){
            userVO.setUserPassword(userPassword);
            userService.updatePw(userVO);
            return "/passwordResetCompletion";
        }
        else{
            return "/passwordResetfail";
        }





    }

}
