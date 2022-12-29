package com.example.kirikiri.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class Criteria {
    private String userId;
    private Integer page;

//    public Criteria(String userId){
//        this.userId = userId;
//        this.page = 1;
//    }
}
