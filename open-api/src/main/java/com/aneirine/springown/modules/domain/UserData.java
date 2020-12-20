package com.aneirine.springown.modules.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "User data model")
public class UserData {

    @ApiModelProperty(notes = "Login for user", example = "aneirine", required = true)
    private String login;
    @ApiModelProperty(notes = "Password for user", example = "qwerty123!", required = true)
    private String password;
}
