package com.eventcafecloud.post.dto;

import com.eventcafecloud.post.domain.type.Board;
import com.eventcafecloud.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public class PostCreateRequestDto {
    private String postTitle;
    private String postContent;
    private Board boardType;
    private User userNumber;

    @Builder
    public PostCreateRequestDto(String postTitle, String postContent, Board board, User userNumber) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.boardType = board;
        this.userNumber = userNumber;
    }
}
