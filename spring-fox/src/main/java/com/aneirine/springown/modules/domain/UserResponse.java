package com.aneirine.springown.modules.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    @ApiModelProperty(value = "User identifier", example = "1")
    private long id;
    @ApiModelProperty(value = "User login", example = "aneirine")
    private String login;

}
