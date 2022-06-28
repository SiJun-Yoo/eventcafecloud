package com.eventcafecloud.post.dto;

import com.eventcafecloud.post.domain.type.Board;
import com.eventcafecloud.user.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public class PostCreateRequestDto {
    private String postTitle;
    private String postContent;
    private Board boardType;
    private User userNumber;
}
