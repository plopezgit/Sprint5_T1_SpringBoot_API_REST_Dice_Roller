package com.plopez.diceroller.microservice.game.model.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmptyGameListException extends RuntimeException {

    private String message;
}
