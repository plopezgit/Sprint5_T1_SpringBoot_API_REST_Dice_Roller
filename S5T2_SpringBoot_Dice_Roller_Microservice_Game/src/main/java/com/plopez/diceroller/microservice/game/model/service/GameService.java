package com.plopez.diceroller.microservice.game.model.service;

import com.plopez.diceroller.microservice.game.model.dto.GameDTO;
import com.plopez.diceroller.microservice.game.model.entity.Game;
import com.plopez.diceroller.microservice.game.model.exception.GameNotFoundException;
import com.plopez.diceroller.microservice.game.model.repository.GameRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService implements GameServiceInterface {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private ModelMapper gameModelMapper;

    @Override
    public List<GameDTO> getGames() {
        List<Game> players = gameRepository.findAll();
        return players.stream().map(this::getGameDTOFromEntity).collect(Collectors.toList());
    }

    @Override
    public GameDTO getGameBy(int id) throws GameNotFoundException {
        return gameRepository.findById(id).map(this::getGameDTOFromEntity)
                .orElseThrow(() -> new GameNotFoundException("The game does not exist"));
    }

    @Override
    public void createGame(GameDTO gameDTO) {
        gameRepository.save(getGameEntityFromDTO(new GameDTO(gameDTO.getPlayerId())));
    }

    @Override
    public void deleteGameBy(int id) {
        gameRepository.deleteById(id);
    }

    @Override
    public List<GameDTO> findGamesByPlayerId(int playerId) {
        List<Game> players = gameRepository.findGamesByPlayerId(playerId);
        return players.stream().map(this::getGameDTOFromEntity).collect(Collectors.toList());
    }

    private GameDTO getGameDTOFromEntity(Game game) {
        return gameModelMapper.map(game, GameDTO.class);
    }

    private Game getGameEntityFromDTO(GameDTO gameDTO) {
        return gameModelMapper.map(gameDTO, Game.class);
    }

}
