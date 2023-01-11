package com.example.kirikiri.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/file/*")
@Slf4j
public class FileController {
    @PostMapping("/upload")
    public String upload(@RequestParam("upload") MultipartFile file) throws IOException {
        String userProfile;
        String path = "C:/upload";
        String uuid = UUID.randomUUID().toString();
        userProfile = uuid + "_" + file.getOriginalFilename();
        File fullPath = new File(path, userProfile);
        file.transferTo(fullPath);

        return userProfile;
    }
    @GetMapping("/display")
    public byte[] display(@RequestParam("userProfile") String userProfile) throws IOException{
       return FileCopyUtils.copyToByteArray(new File("C:/upload", userProfile));
    }
}
