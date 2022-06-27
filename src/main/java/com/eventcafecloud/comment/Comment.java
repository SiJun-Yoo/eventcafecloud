package com.eventcafecloud.comment;


import com.eventcafecloud.post.domain.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNumber;

    @Column(nullable = false)
    private String commentContent;

    @ManyToOne
    @JoinColumn(name = "post_number")
    private Post post;

//    @ManyToOne
//    @JoinColumn(name = "user_number")
//    private User user;
}
