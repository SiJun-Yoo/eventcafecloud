package com.eventcafecloud.post.service;

import com.eventcafecloud.post.domain.Post;
import com.eventcafecloud.post.dto.*;
import com.eventcafecloud.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public PostCreateResponseDto createPost(PostCreateRequestDto requestDto) {

        Post post = new Post();
        post.setPostTitle(requestDto.getPostTitle());
        post.setPostContent(requestDto.getPostContent());
        Post postResult = postRepository.save(post);

        return PostCreateResponseDto.builder()
                .postContent(postResult.getPostContent())
                .board(postResult.getBoard())
                .postTitle(postResult.getPostTitle())
                .build();

    }

    public List<PostReadResponseDto> getPost() {
        List<Post> post = postRepository.findAll();
        List<PostReadResponseDto> output = new ArrayList<>();

        for (int i = 0; i < post.size(); i++) {
            PostReadResponseDto postReadResponseDto = new PostReadResponseDto();
            postReadResponseDto.setBoardNumber(post.get(i).getPostNumber());
            postReadResponseDto.setPostTitle(post.get(i).getPostTitle());
            postReadResponseDto.setPostContent(post.get(i).getPostContent());
            output.add(postReadResponseDto);
        }
        return output;
    }

    @Transactional
    public PostUpdateResponseDto updatePost(@PathVariable Long PostNumber, PostCreateRequestDto requestDto){
        Post post = postRepository.findById(PostNumber).orElseThrow(
                ()-> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        post.updatePost(requestDto);
        return PostUpdateResponseDto.builder()
                .postNumber(post.getPostNumber())
                .build();
    }

    public PostDeleteResponseDto deletePost(Long postNumber) {
        PostDeleteResponseDto postDeleteResponseDto = new PostDeleteResponseDto(postNumber);
        postRepository.deleteById(postNumber);
        return postDeleteResponseDto;
    }
}
