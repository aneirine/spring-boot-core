package com.aneirine.springown.modules.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserData {

    @ApiModelProperty(value = "Login for User", example = "a.o.pavlenko")
    private String login;
    @ApiModelProperty(value = "Password for User", example = "qwerty123!")
    private String password;
}
