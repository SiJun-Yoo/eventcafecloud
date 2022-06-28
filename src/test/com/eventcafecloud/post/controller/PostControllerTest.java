package com.eventcafecloud.post.controller;

import com.eventcafecloud.post.domain.Post;
import com.eventcafecloud.post.dto.PostCreateRequestDto;
import com.eventcafecloud.post.dto.PostCreateResponseDto;
import com.eventcafecloud.post.service.PostService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class PostControllerTest {

    @Autowired
    PostService postService;

    @Test
    void createPostTest(){
        // given
        PostCreateRequestDto postCreateRequestDto = PostCreateRequestDto.builder()
                .postTitle("게시글 등록 테스트")
                .postContent("등록 내용")
                .build();
        // when
        PostCreateResponseDto post = postService.createPost(postCreateRequestDto);
        // then
        Assertions.assertThat("글등록 내용" ).isEqualTo(post.getPostContent());
    }

    @Test
    void postRead(){
        // given
        // when
        // then

    }

}