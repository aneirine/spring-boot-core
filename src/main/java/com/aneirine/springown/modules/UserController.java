package com.aneirine.springown.modules;

import com.aneirine.springown.exception.RestError;
import com.aneirine.springown.modules.domain.UserData;
import com.aneirine.springown.modules.domain.UserResponse;
import io.swagger.annotations.*;
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

    @ApiOperation(value = "Створити користувача з вхідних даних")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User was created", response = UserResponse.class),
            @ApiResponse(code = 409, message = "LOGIN_ALREADY_EXISTS", response = RestError.class)
    })
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody UserData data) {
        return new ResponseEntity(userService.createUser(data), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Достати користувача з вхідних даних")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get user", response = UserResponse.class),
            @ApiResponse(code = 404, message = "USER_NOT_FOUND", response = RestError.class)
    })
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserById(@PathVariable("id") @ApiParam(value = "Ідентифікатор користувача", example = "1", required = true) long id) {
        return new ResponseEntity(userService.getUserById(id), HttpStatus.OK);
    }

    /*@GetMapping("/example")
    public Object example(@Parameter(name = "json", schema = @Schema(description = "var 1", type = "string", allowableValues = {"1", "2"}))
                                  String json) {
        return null;
    }*/
}
