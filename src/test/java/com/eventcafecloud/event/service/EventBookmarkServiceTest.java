package com.eventcafecloud.event.service;

import com.eventcafecloud.user.domain.User;
import com.eventcafecloud.user.domain.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


/**
 * todo
 * User Domain 변경으로 인해 작성불가
 * User Domain이 작성되고 생성자 혹은 Builder가 있다면 테스트 코드 작성예정
 */
@SpringBootTest
class EventBookmarkServiceTest {
    @Autowired
    private EventBookmarkService eventBookmarkService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void createBookmark() {

    }

    @Test
    void deleteBookmark() {
    }
}