package com.eventcafecloud.post.controller;

import com.eventcafecloud.post.dto.*;
import com.eventcafecloud.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;

    //게시글 등록
    @PostMapping("/board")
    @ResponseBody
    public PostCreateResponseDto createPost(@RequestBody PostCreateRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    //모든 게시판 조회
    @GetMapping("/board")
    public String getPost(Model model) {
        model.addAttribute("posts", postService.getPost());
        return "post/board";
    }

    //게시글 업데이트
    @PutMapping("/board/{postNumber}")
    @ResponseBody
    public PostUpdateResponseDto updatePost(@PathVariable Long postNumber, @RequestBody PostUpdateRequestDto requestDto) {
        return postService.updatePost(postNumber, requestDto);
    }

    //게시글 삭제
    @DeleteMapping("/delete/{postNumber}")
    @ResponseBody
    public ResponseVO<PostDeleteResponseDto> deletePost(@PathVariable Long postNumber) {
        return postService.deletePost(postNumber);
    }
}
