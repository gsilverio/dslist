package com.ggsilverio.dslist.service;

import com.ggsilverio.dslist.dto.GameMinDTO;
import com.ggsilverio.dslist.entities.Game;
import com.ggsilverio.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    public List<GameMinDTO> findAll() {

        List<Game> gameList = gameRepository.findAll();
        return gameList.stream().map(x->new GameMinDTO(x)).toList();
    }



}
