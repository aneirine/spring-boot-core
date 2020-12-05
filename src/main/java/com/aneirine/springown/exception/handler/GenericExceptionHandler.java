package com.aneirine.springown.exception.handler;

import com.aneirine.springown.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@ControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        //Get all errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(ValidationErrorBuilder.fromBindingErrors(errors));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException exception, WebRequest request){
        log.warn(exception.getMessage());
        return new ResponseEntity<>(new RestError(NOT_FOUND.value(), exception.getMessage()), NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException exception, WebRequest request) {
        log.warn(exception.getMessage());
        return new ResponseEntity<>(new RestError(BAD_REQUEST.value(), exception.getMessage()), BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Object> handleUnauthorizedException(UnauthorizedException exception, WebRequest request) {
        log.warn(exception.getMessage());
        return new ResponseEntity<>(new RestError(UNAUTHORIZED.value(), exception.getMessage()), UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<Object> handleInvalidTokenException(InvalidTokenException exception, WebRequest request) {
        log.warn(exception.getMessage());
        return new ResponseEntity<>(new RestError(FORBIDDEN.value(), exception.getMessage()), FORBIDDEN);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<Object> handleForbiddenException(ForbiddenException exception, WebRequest request) {
        log.warn(exception.getMessage());
        return new ResponseEntity<>(new RestError(FORBIDDEN.value(), exception.getMessage()), FORBIDDEN);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<Object> handleConflictException(ConflictException exception, WebRequest request) {
        log.warn(exception.getMessage());
        return new ResponseEntity<>(new RestError(CONFLICT.value(), exception.getMessage()), CONFLICT);
    }


}
