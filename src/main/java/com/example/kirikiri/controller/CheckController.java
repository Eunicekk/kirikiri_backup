package com.example.kirikiri.controller;

import com.example.kirikiri.domain.UserVO;
import com.example.kirikiri.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/check/*")
@RequiredArgsConstructor
public class CheckController {
    private final UserService userService;

    @GetMapping("/duplicateId")
    public Boolean duplicateId(@RequestParam("userId")String userId) {
        Boolean check = userService.duplicateCheckId(userId);
        return check;
    }
    @GetMapping("/duplicateNickname")
    public Boolean duplicateNickname(@RequestParam("userNickname")String userNickname) {
        Boolean check = userService.duplicateCheckNickname(userNickname);
        return check;
    }
}
