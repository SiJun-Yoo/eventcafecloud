package com.eventcafecloud.user.domain;

import com.eventcafecloud.common.base.BaseTimeEntity;
import com.eventcafecloud.post.domain.Post;
import com.eventcafecloud.user.domain.type.Gender;
import com.eventcafecloud.user.domain.type.UserStatus;
import com.eventcafecloud.user.domain.type.Role;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class User extends BaseTimeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long userNumber;

    @Column(length = 100)
    private String userEmail;

    @Column(length = 100)
    private String userNickname;

    @Enumerated(EnumType.STRING)
    private Gender userGender;

    @Column(length = 100)
    private String userImage;

    @Column(length = 100)
    private String userRegPath;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();
}
