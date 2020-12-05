package com.aneirine.springown.modules;

import com.aneirine.springown.entities.User;
import com.aneirine.springown.modules.domain.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserModelHandler {

    public UserResponse buildUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .login(user.getLogin())
                .build();
    }
}
