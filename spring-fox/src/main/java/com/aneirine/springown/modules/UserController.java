package com.aneirine.springown.modules;

import com.aneirine.springown.modules.domain.UserData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody UserData data) {
        return new ResponseEntity(userService.createUser(data), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserById(@PathVariable long id) {
        return new ResponseEntity(userService.getUserById(id), HttpStatus.OK);
    }


}
