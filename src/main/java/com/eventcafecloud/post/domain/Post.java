package com.eventcafecloud.post.domain;

import com.eventcafecloud.board.Board;
import com.eventcafecloud.post.dto.PostCreateRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postNumber;

    @Column(nullable = false)
    private String postTitle;

    @Column(nullable = false)
    private String postContent;

    @ManyToOne
    @JoinColumn(name = "board_number")
    private Board board;

    public void updatePost(PostCreateRequestDto requestDto) {
        this.postContent = requestDto.getPostContent();
    }

//    @ManyToOne
//    @JoinColumn(name = "user_number")
//    private User user;


}
