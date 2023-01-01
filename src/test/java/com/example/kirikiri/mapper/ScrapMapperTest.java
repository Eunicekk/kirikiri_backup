package com.example.kirikiri.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ScrapMapperTest {
    @Autowired
    private ScrapMapper scrapMapper;

    @Test
    public void test(){
        scrapMapper.test("kevs");
    }

    @Test
    public void test2(){scrapMapper.selectScrapped("kevs",1);}
}
