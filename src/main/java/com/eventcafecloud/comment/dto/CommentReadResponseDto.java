package com.eventcafecloud.comment.dto;

import com.eventcafecloud.user.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentReadResponseDto {
    private Long commentNumber;
    private String commentContent;
    private User userNumber;

}
