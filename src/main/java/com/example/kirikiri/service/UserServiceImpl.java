package com.example.kirikiri.service;

import com.example.kirikiri.domain.UserVO;
import com.example.kirikiri.repository.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("user") @Primary
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Override
    public void signup(UserVO userVO) {
        userDAO.setUserVO(userVO);
    }

    @Override
    public UserVO login(UserVO userVO) {
        return userDAO.getUserVO(userVO);
    }

    @Override
    public UserVO getUserVOById(String userId) {
        return userDAO.getUserVOById(userId);
    }
    @Override
    public UserVO getInfo(String userId){return userDAO.userInfoById(userId);}

    @Override
    public void updateInfo(UserVO userVO){userDAO.updateUserInfo(userVO);}

    @Override
    public void deleteInfo(String userId){userDAO.deleteUser(userId);}
}
