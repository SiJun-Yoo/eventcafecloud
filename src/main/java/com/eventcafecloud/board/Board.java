package com.eventcafecloud.board;

import com.eventcafecloud.common.base.BaseTimeEntity;
import com.eventcafecloud.post.domain.Post;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Board extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNumber;

    private String boardName;

    @OneToMany(mappedBy = "board")
    private List<Post> posts = new ArrayList<>();
}
