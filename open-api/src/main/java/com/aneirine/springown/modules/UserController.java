package com.aneirine.springown.modules;

import com.aneirine.springown.exception.RestError;
import com.aneirine.springown.modules.domain.UserData;
import com.aneirine.springown.modules.domain.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.aneirine.springown.exception.Exceptions.User.LOGIN_ALREADY_EXISTS;
import static com.aneirine.springown.exception.Exceptions.User.USER_NOT_FOUND;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "Create User", description = "Create user from User data", tags = {"Users"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created",
                    content = @Content(schema = @Schema(implementation = UserResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "409", description = "Login already exists", content = @Content
                    (schema = @Schema(implementation = RestError.class), examples = @ExampleObject(description = "Conflict exception", value = LOGIN_ALREADY_EXISTS))
            )})
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody UserData data) {
        return new ResponseEntity(userService.createUser(data), HttpStatus.CREATED);
    }


    @Operation(summary = "Get User", description = "Get User by id", tags = {"Users"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User was found",
                    content = @Content(schema = @Schema(implementation = UserResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content
                    (schema = @Schema(implementation = RestError.class), examples = @ExampleObject(description = "Not Found Exception", value = USER_NOT_FOUND))
            )})
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserById(@Parameter(description = "Id of the user to be obtained. Cannot be empty.", required = true)
                                      @PathVariable long id) {
        return new ResponseEntity(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/example")
    public Object example(@Parameter(name = "json", schema = @Schema(description = "var 1", type = "string", allowableValues = {"1", "2"}))
                                  String json) {
        return null;
    }
}
