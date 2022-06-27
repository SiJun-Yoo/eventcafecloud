package com.eventcafecloud.post.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostReadResponseDto {
    private Long boardNumber;
    private String postTitle;
    private String postContent;
}
