package com.eventcafecloud.post.domain;

import com.eventcafecloud.comment.Comment;
import com.eventcafecloud.common.base.BaseTimeEntity;
import com.eventcafecloud.post.dto.PostCreateRequestDto;
import com.eventcafecloud.user.domain.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postNumber;

    @Column(nullable = false)
    private String postTitle;

    @Column(nullable = false)
    private String postContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_number")
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<PostImage> postImages = new ArrayList<>();


    public void updatePost(PostCreateRequestDto requestDto) {
        this.postContent = requestDto.getPostContent();
    }

}
