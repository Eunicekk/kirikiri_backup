package com.example.kirikiri.repository;

import com.example.kirikiri.mapper.BoardFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardFileDAO {
    private final BoardFileMapper boardFileMapper;
}
