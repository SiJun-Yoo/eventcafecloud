package com.eventcafecloud.user.service;

import com.eventcafecloud.user.domain.User;
import com.eventcafecloud.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private  final UserRepository userRepository;

    public User getUser(String userEmail){
        return userRepository.findByUserEmail(userEmail);
    }
}
