package com.example.kirikiri.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data @NoArgsConstructor
public class UserVO {
//    USER_ID VARCHAR2(1000) CONSTRAINT PK_USER PRIMARY KEY,
//    USER_PASSWORD VARCHAR2(1000) NOT NULL,
//    USER_NICKNAME VARCHAR2(1000) NOT NULL UNIQUE,
//    USER_EMAIL VARCHAR2(1000) NOT NULL,
//    USER_NAME VARCHAR2(1000) NOT NULL,
//    USER_NATION VARCHAR2(1000) NOT NULL,
//    USER_EMAIL_RECEIVE_CHECK CHAR(1),
//    USER_REGISTER_DATE DATE DEFAULT SYSDATE,
//    USER_PROFILE VARCHAR(1000)

    private String userId;
    private String userPassword;
    private String userNickname;
    private String userEmail;
    private String userName;
    private String userNation;
    private char userEmailReceiveCheck;
    private String userRegisterDate;
    private String userProfile;
    private Integer userAge;
    private String userResidence;
    private char userAgeCheck;
    private char userResidenceCheck;

    @Builder
    public UserVO(String userId, String userPassword, String userNickname, String userEmail, String userName, String userNation, char userEmailReceiveCheck, String userProfile, Integer userAge, String userResidence, char userAgeCheck, char userResidenceCheck) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userNickname = userNickname;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userNation = userNation;
        this.userEmailReceiveCheck = userEmailReceiveCheck;
        this.userProfile = userProfile;
        this.userAge = userAge;
        this.userResidence = userResidence;
        this.userAgeCheck = userAgeCheck;
        this.userResidenceCheck = userResidenceCheck;
    }
}