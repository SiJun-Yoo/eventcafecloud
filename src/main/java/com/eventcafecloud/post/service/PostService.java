package com.eventcafecloud.post.service;

import com.eventcafecloud.post.domain.Post;
import com.eventcafecloud.post.dto.*;
import com.eventcafecloud.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    //게시글 생성
    public PostCreateResponseDto createPost(PostCreateRequestDto requestDto) {

        Post post = new Post();
        post.setPostTitle(requestDto.getPostTitle());
        post.setPostContent(requestDto.getPostContent());
        post.setBoardType(requestDto.getBoardType());
        post.setUser(requestDto.getUserNumber());
        Post postResult = postRepository.save(post);

        return PostCreateResponseDto.builder()
                .postContent(postResult.getPostContent())
                .board(postResult.getBoardType())
                .postTitle(postResult.getPostTitle())
                .userNumber(postResult.getUser())
                .build();

    }
    //게시글 조회
    public List<PostReadResponseDto> getPost() {
        List<Post> post = postRepository.findAll();
        List<PostReadResponseDto> output = new ArrayList<>();

        for (Post value : post) {
            PostReadResponseDto postReadResponseDto = new PostReadResponseDto();
            postReadResponseDto.setPostNumber(value.getPostNumber());
            postReadResponseDto.setPostTitle(value.getPostTitle());
            postReadResponseDto.setPostContent(value.getPostContent());
            postReadResponseDto.setBoardType(value.getBoardType());
            postReadResponseDto.setUserNumber(value.getUser());
            output.add(postReadResponseDto);
        }
        return output;
    }
    //게시글 업데이트
    @Transactional
    public PostUpdateResponseDto updatePost(@PathVariable Long PostNumber, PostUpdateRequestDto requestDto){
        Post post = postRepository.findById(PostNumber).orElseThrow(
                ()-> new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );
        post.updatePost(requestDto);
        return PostUpdateResponseDto.builder()
                .postNumber(post.getPostNumber())
                .userNumber(post.getUser())
                .build();
    }

    //게시글 삭제
    public ResponseVO<PostDeleteResponseDto> deletePost(Long postNumber) {
        PostDeleteResponseDto postDeleteResponseDto = new PostDeleteResponseDto(postNumber);
        ResponseVO<PostDeleteResponseDto> responseVO = new ResponseVO<PostDeleteResponseDto>();
        try{
            postRepository.deleteById(postNumber);
            responseVO.setStatus(true);
            responseVO.setMsg("삭제에 성공 하였습니다.");
            responseVO.setResult(postDeleteResponseDto);
        }catch (Exception e){
            responseVO.setStatus(false);
            responseVO.setMsg("삭제에 실패 하였습니다.");
            responseVO.setResult(postDeleteResponseDto);
        }
        return responseVO;
    }
}
