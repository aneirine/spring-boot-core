package com.aneirine.springown.modules;

import com.aneirine.springown.exception.RestError;
import com.aneirine.springown.modules.domain.UserData;
import com.aneirine.springown.modules.domain.UserResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Api(tags = "Users")
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "Create user from data", response = UserResponse.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "User was created", response = UserResponse.class),
            @ApiResponse(code = 409, message = "Login Already Exists", response = RestError.class)
    })
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody UserData data) {
        return new ResponseEntity(userService.createUser(data), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserById(@PathVariable long id) {
        return new ResponseEntity(userService.getUserById(id), HttpStatus.OK);
    }


}
