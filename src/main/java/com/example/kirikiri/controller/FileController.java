package com.example.kirikiri.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/file/*")
@Slf4j
public class FileController {

    @GetMapping("/display")
    public byte[] display(String path) throws IOException{
       return FileCopyUtils.copyToByteArray(new File("C:/upload", path));
    }
}
