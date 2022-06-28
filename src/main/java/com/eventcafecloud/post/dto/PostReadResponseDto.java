package com.eventcafecloud.post.dto;

import com.eventcafecloud.post.domain.type.Board;
import com.eventcafecloud.user.domain.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostReadResponseDto {
    private Long postNumber;
    private String postTitle;
    private String postContent;
    private Board BoardType;
    private User userNumber;
}
