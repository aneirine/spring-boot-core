package com.aneirine.springown.modules.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "User response model")
public class UserResponse {

    @ApiModelProperty(notes = "Id of user", example = "1")
    private long id;
    @ApiModelProperty(notes = "Login for user", example = "aneirine")
    private String login;

}
