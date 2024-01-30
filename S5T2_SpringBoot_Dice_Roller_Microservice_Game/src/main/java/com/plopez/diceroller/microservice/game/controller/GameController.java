package com.plopez.diceroller.microservice.game.controller;

import com.plopez.diceroller.microservice.game.model.dto.GameDTO;
import com.plopez.diceroller.microservice.game.model.exception.GameNotFoundException;
import com.plopez.diceroller.microservice.game.model.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
@SuppressWarnings("unused")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<?> getGames() {
        List<GameDTO> gamesDTO = gameService.getGames();
        if (gamesDTO.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(gamesDTO);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGame(@PathVariable int id) {
        return ResponseEntity.ok(gameService.getGameBy(id));
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<?> deleteGames(@PathVariable int id) {
        gameService.deleteGamesBy(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/player/{playerId}")
    public ResponseEntity<?> getGamesByPlayerId(@PathVariable int playerId) {
        List<GameDTO> gamesDTO = gameService.findGamesByPlayerId(playerId);
        if (gamesDTO.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(gamesDTO);
        }
    }

    @PostMapping("/{playerId}/player")
    public ResponseEntity<?> createGameBy(@PathVariable int playerId) {
        gameService.createGameBy(playerId);
        gameService.updatePlayerSuccessRate(playerId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
