package com.aneirine.springown.modules.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    @Schema(description = "Id of user", example = "1")
    private long id;
    @Schema(description = "Login for user", example = "aneirine")
    private String login;

}
