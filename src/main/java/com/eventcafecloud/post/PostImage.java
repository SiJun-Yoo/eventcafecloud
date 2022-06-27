package com.eventcafecloud.post;

import com.eventcafecloud.post.domain.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class PostImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postImageNumber;

    @Column(nullable = false)
    private String postImageUrl;

    @ManyToOne
    @JoinColumn(name = "post_number")
    private Post post;

}
