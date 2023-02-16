package com.yeseul.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
//선언된 모든 final 필드가 포함된 생성자를 생성해줌
public class HelloResponseDto {
    private final String name;
    private final int amount;

}
