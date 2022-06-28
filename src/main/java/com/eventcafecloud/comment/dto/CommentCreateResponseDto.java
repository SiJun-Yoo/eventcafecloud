package com.eventcafecloud.comment.dto;

import com.eventcafecloud.post.domain.Post;
import com.eventcafecloud.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommentCreateResponseDto {
    private String commentContent;
    private Post postNumber;
    private User userNumber;

    @Builder
    public CommentCreateResponseDto(String commentContent, Post postNumber, User userNumber) {
        this.commentContent = commentContent;
        this.postNumber = postNumber;
        this.userNumber = userNumber;
    }
}
