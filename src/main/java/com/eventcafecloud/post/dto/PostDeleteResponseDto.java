package com.eventcafecloud.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder

public class PostDeleteResponseDto {
    private Long postNumber;
}
