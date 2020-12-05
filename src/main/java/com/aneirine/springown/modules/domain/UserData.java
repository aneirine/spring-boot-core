package com.aneirine.springown.modules.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserData {

    @Schema(description = "Login for user", example = "aneirine", required = true)
    private String login;
    @Schema(description = "Password for user", example = "qwerty123!", required = true)
    private String password;
}
