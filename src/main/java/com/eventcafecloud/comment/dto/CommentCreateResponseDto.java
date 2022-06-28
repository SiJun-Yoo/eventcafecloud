package com.eventcafecloud.comment.dto;

import com.eventcafecloud.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommentCreateResponseDto {
    private String commentContent;
    private User userNumber;

    @Builder
    public CommentCreateResponseDto(String commentContent, User userNumber) {
        this.commentContent = commentContent;
        this.userNumber = userNumber;
    }
}
