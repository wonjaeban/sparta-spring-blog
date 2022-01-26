package com.sparta.blog.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor

public class MemoRequestDto {
    private String title;
    private String username;
    private String contents;
}
