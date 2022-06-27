package com.eventcafecloud.comment;
import com.eventcafecloud.common.base.BaseTimeEntity;
import com.eventcafecloud.post.domain.Post;
import com.eventcafecloud.user.domain.User;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity

public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNumber;

    @Column(nullable = false)
    private String commentContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_number")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_number")
    private User user;
    

}
