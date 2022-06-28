package com.eventcafecloud.comment.service;

import com.eventcafecloud.comment.domain.Comment;
import com.eventcafecloud.comment.dto.*;
import com.eventcafecloud.comment.repository.CommentRepository;
import com.eventcafecloud.post.dto.PostDeleteResponseDto;
import com.eventcafecloud.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    //댓글 생성
    public CommentCreateResponseDto createComment(CommentCreateRequestDto requestDto) {

        Comment comment = new Comment();
        comment.setCommentContent(requestDto.getCommentContent());
        Comment commentResult = commentRepository.save(comment);

        return CommentCreateResponseDto.builder()
                .commentContent(commentResult.getCommentContent())
                .userNumber(commentResult.getUser())
                .build();
    }
    //댓글 조회
    public List<CommentReadResponseDto> getComment() {
        List<Comment> comments = commentRepository.findAll();
        List<CommentReadResponseDto> output = new ArrayList<>();

        for (Comment value : comments) {
            CommentReadResponseDto commentReadResponseDto = new CommentReadResponseDto();
            commentReadResponseDto.setCommentContent(value.getCommentContent());
            commentReadResponseDto.setCommentNumber(value.getCommentNumber());
            commentReadResponseDto.setUserNumber(value.getUser());
            output.add(commentReadResponseDto);
        }
        return output;
    }
    //댓글 업데이트
    @Transactional
    public CommentUpdateResponseDto updateComment(@PathVariable Long CommentNumber, CommentUpdateRequestDto requestDto) {
        Comment comment = commentRepository.findById(CommentNumber).orElseThrow(
                () -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다")
        );
        comment.updateComment(requestDto);
        return CommentUpdateResponseDto.builder()
                .commentContent(comment.getCommentContent())
                .userNumber(comment.getUser())
                .build();
    }
    //댓글 삭제
    public ResponseVO<CommentDeleteResponseDto> deleteComment(Long commentNumber){
        CommentDeleteResponseDto commentDeleteResponseDto = new CommentDeleteResponseDto(commentNumber);
        ResponseVO<CommentDeleteResponseDto> responseVO = new ResponseVO<CommentDeleteResponseDto>();
        try{
            commentRepository.deleteById(commentNumber);
            responseVO.setStatus(true);
            responseVO.setMsg("삭제에 성공하였습니다.");
            responseVO.setResult(commentDeleteResponseDto);
        }catch (Exception e){
            responseVO.setStatus(false);
            responseVO.setMsg("삭제에 실패 하였습니다.");
            responseVO.setResult(commentDeleteResponseDto);
        }
        return responseVO;
    }






}
