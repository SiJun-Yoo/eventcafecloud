package com.eventcafecloud.user.domain;

import com.eventcafecloud.common.base.BaseTimeEntity;
import com.eventcafecloud.post.domain.Post;
import com.eventcafecloud.user.domain.type.Role;
import com.eventcafecloud.user.domain.type.UserStatus;
import lombok.Builder;
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

    @Column(length = 100)
    private String userGender;

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

    @Builder

    public User(String userEmail, String userNickname, String userGender, String userImage,
                String userRegPath, Role role, UserStatus userStatus) {
        this.userEmail = userEmail;
        this.userNickname = userNickname;
        this.userGender = userGender;
        this.userImage = userImage;
        this.userRegPath = userRegPath;
        this.role = role;
        this.userStatus = userStatus;
    }

    public User update(String userNickname, String userImage){
        this.userNickname = userNickname;
        this.userImage = userImage;

        return this;
    }
}
