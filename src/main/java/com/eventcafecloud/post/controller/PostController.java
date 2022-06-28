package com.eventcafecloud.post.controller;

import com.eventcafecloud.post.dto.*;
import com.eventcafecloud.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    //게시글 등록
    @PostMapping("/board")
    public PostCreateResponseDto createPost(@RequestBody PostCreateRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    //모든 게시판 조회
    @GetMapping("/board")
    public List<PostReadResponseDto> getPost() {
        return postService.getPost();
    }

    //게시글 업데이트
    @PutMapping("/board/{postNumber}")
    public PostUpdateResponseDto updatePost(@PathVariable Long postNumber, @RequestBody PostUpdateRequestDto requestDto) {
        return postService.updatePost(postNumber, requestDto);
    }

    //게시글 삭제
    @DeleteMapping("/delete/{postNumber}")
    public ResponseVO<PostDeleteResponseDto> deletePost(@PathVariable Long postNumber) {
        return postService.deletePost(postNumber);
    }
}
