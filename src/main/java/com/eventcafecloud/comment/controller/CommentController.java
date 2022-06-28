package com.eventcafecloud.comment.controller;

import com.eventcafecloud.comment.dto.*;
import com.eventcafecloud.comment.service.CommentService;
import com.eventcafecloud.post.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    //댓글 등록
    @PostMapping("/comment")
    public CommentCreateResponseDto createComment(@RequestBody CommentCreateRequestDto requestDto){
        return commentService.createComment(requestDto);
    }

    //댓글 조회
    @GetMapping("/comment")
    public List<CommentReadResponseDto> getComment() {
        return commentService.getComment();
    }

    //댓글 업데이트
    @PutMapping("/comment/{commentNumber}")
    public CommentUpdateResponseDto updateComment(@PathVariable Long commentNumber, @RequestBody CommentUpdateRequestDto requestDto) {
        return commentService.updateComment(commentNumber, requestDto);
    }

    //댓글 삭제
    @DeleteMapping("/deleteComment/{commentNumber}")
    public ResponseVO<CommentDeleteResponseDto> deleteComment(@PathVariable Long commentNumber){
        return commentService.deleteComment(commentNumber);
    }
}
