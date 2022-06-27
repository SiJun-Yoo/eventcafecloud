package com.eventcafecloud.post.controller;

import com.eventcafecloud.post.dto.*;
import com.eventcafecloud.post.service.PostService;
import com.eventcafecloud.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping("/board")
    public PostCreateResponseDto createPost(@RequestBody PostCreateRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    //모든 게시판 조회
    @GetMapping("/board")
    public List<PostReadResponseDto> getPost() {
        return postService.getPost();
    }

    @PutMapping("/board/{postNumber}")
    public PostUpdateResponseDto updatePost(@PathVariable Long postNumber, @RequestBody PostCreateRequestDto requestDto) {
        return postService.updatePost(postNumber, requestDto);
    }

    @DeleteMapping("/delete/{postNumber}")
    public PostDeleteResponseDto deletePost(@PathVariable Long postNumber) {
        return postService.deletePost(postNumber);
    }
}
