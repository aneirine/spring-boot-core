package com.aneirine.springown.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestError {
    private int status;
    @Schema(description = "Message" )
    private String message;
}
