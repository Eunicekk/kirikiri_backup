package com.example.kirikiri.controller;

import com.example.kirikiri.domain.ScrapVO;
import com.example.kirikiri.domain.UserVO;
import com.example.kirikiri.service.ScrapService;
import com.example.kirikiri.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class CheckController {
    private final UserService userService;
    private final ScrapService scrapService;

    @GetMapping("/check/duplicateId")
    public Boolean duplicateId(@RequestParam("userId")String userId) {
        Boolean check = userService.duplicateCheckId(userId);
        return check;
    }
    @GetMapping("/duplicateNickname")
    public Boolean duplicateNickname(@RequestParam("userNickname")String userNickname) {
        Boolean check = userService.duplicateCheckNickname(userNickname);
        return check;
    }
    @GetMapping("/scrap/add")
    public String addScrap(ScrapVO scrapVO){
        scrapService.addScrap(scrapVO);
        return "추가 성공!!";
    }
    @GetMapping("/scrap/delete")
    public String removeScrap(ScrapVO scrapVO){
        scrapService.deleteScrap(scrapVO);
        return "삭제 성공!!";
    }
}
