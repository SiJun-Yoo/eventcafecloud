package com.eventcafecloud.comment.dto;

import com.eventcafecloud.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CommentUpdateResponseDto {
    private String commentContent;
    private User userNumber;
}
