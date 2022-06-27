package com.eventcafecloud.post.dto;

import com.eventcafecloud.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public class PostCreateResponseDto {
    private String postTitle;
    private String postContent;
    private Board board;


    @Builder
    public PostCreateResponseDto(String postTitle, String postContent, Board board) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.board = board;
    }
}
