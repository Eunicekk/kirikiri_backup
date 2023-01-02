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

    private  final UserDAO userDAO;

    @Override
    public String findById(String userEmail) {
        return userDAO.findById(userEmail);
    }

    @Override
    public UserVO getUser(String userId){
        return userDAO.findId(userId);
    }

    @Override
    public void updatePw(UserVO userVO) {
        userDAO.setUserPw(userVO);
    }


}
