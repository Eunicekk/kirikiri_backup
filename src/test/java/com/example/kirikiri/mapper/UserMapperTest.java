package com.example.kirikiri.mapper;

import com.example.kirikiri.domain.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserMapperTest {
    @Autowired
<<<<<<< HEAD
    UserMapper userMapper;

    @Test
    public void insertTest(){
        UserVO userVO = new UserVO();
        userVO.setUserId("aaaaaabb");
        userVO.setUserPassword("aaa");
        userVO.setUserNickname("aaaaaabb");
        userVO.setUserEmail(("aaaaaa"));
        userVO.setUserName(("aaa"));
        userVO.setUserNation("aaa");

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
=======
    private UserMapper userMapper;

    @Test
    public void selectUserEmailTest(){
        log.info("ID : "+userMapper.selectUserEmail("test@email.com"));
    }

    @Test
    public void selectUserIdTest(){
        log.info(userMapper.selectUserId("testId").toString());
    }


    @Test
    public void updatePwTest(){
        //                비밀번호를 변경할 ID
        UserVO userVO = userMapper.selectUserId("testId");
        //                변경 비밀번호
        userVO.setUserPassword("수정한비밀번호");
        userMapper.updatePw(userVO);
    }

    @Test
    public void insertTest(){
        UserVO userVO = UserVO.builder()
                .userId("asdf")
                .userPassword("asdf")
                .userNickname("asdf")
                .userEmail("asdf@asdf.com")
                .userName("asdf")
                .userNation("asdf")
                .userEmailReceiveCheck('1')
                .userProfile("asdf")
                .build();
        userMapper.insert(userVO);
    }




>>>>>>> 319665cc80c20ee6a1e79404e302516cbcb43a4d
}
