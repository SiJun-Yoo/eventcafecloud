package com.eventcafecloud.post.dto;


import com.eventcafecloud.board.Board;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public class PostCreateRequestDto {
    private String postTitle;
    private String postContent;
    private Board board;
}
