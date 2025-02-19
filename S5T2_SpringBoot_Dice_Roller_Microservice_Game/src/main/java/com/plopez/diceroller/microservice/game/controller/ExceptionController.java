package com.plopez.diceroller.microservice.game.controller;


import com.plopez.diceroller.microservice.game.model.exception.GameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.rmi.ServerException;
import java.util.Date;

@SuppressWarnings("unused")
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(GameNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseMessage> gameNotFoundExceptionHandler(GameNotFoundException exception, WebRequest request) {
        return new ResponseEntity<>(ResponseMessage.builder()
                .responseCode(HttpStatus.NOT_FOUND.value())
                .message(exception.getMessage())
                .messageDescription(request.getDescription(false))
                .responseTimeStamp(new Date())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseMessage> httpMediaTypeNotSupportedExceptionHandler(HttpMediaTypeNotSupportedException exception, WebRequest request) {
        return new ResponseEntity<>(ResponseMessage.builder()
                .responseCode(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .messageDescription(request.getDescription(false))
                .responseTimeStamp(new Date())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ResponseMessage> serverExceptionHandler(Exception exception, WebRequest request) {
        return new ResponseEntity<>(ResponseMessage.builder()
                .responseCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(exception.getMessage())
                .messageDescription(request.getDescription(false))
                .responseTimeStamp(new Date())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
