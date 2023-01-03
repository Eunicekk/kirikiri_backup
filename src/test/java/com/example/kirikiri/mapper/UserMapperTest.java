package com.example.kirikiri.mapper;

import com.example.kirikiri.domain.UserVO;
import com.example.kirikiri.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Test
    public void insertTest(){
        UserVO userVO = new UserVO();
        userVO.setUserId("aaaaaabb");
        userVO.setUserPassword("aaa");
        userVO.setUserNickname("aaaaaabb");
        userVO.setUserEmail(("aaaaaa"));
        userVO.setUserName(("aaa"));
        userVO.setUserNation("aaa");
        userVO.setUserAge(20);
        userVO.setUserResidence("ababab");

        userMapper.insert(userVO);
    }

    @Test
    public void loginTest(){
        UserVO userVO  = new UserVO();
        userVO.setUserId("aaa");
        userVO.setUserPassword("aaa");
        boolean check = false;
        check = (userMapper.select(userVO) == null) ? false : true;
        log.info("" + check);
    }

    @Test
    public void duplicateTest(){
        Boolean check = userService.duplicateCheckId("aaaa");
        log.info("중복검사 : " + check);
    }
}
