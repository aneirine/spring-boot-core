package com.aneirine.springown.modules;

import com.aneirine.springown.entities.User;
import com.aneirine.springown.exception.NotFoundException;
import com.aneirine.springown.modules.domain.UserData;
import com.aneirine.springown.modules.domain.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserModelHandler userModelHandler;

    public UserResponse createUser(UserData data){
        User user = User.builder()
                .login(data.getLogin())
                .password(data.getPassword())
                .build();
        userRepository.save(user);
        return userModelHandler.buildUserResponse(user);
    }

    public UserResponse getUserById(long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("USER_NOY_FOUND"));
        return userModelHandler.buildUserResponse(user);
    }

}
