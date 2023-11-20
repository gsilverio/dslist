package com.ggsilverio.dslist.service;

import com.ggsilverio.dslist.dto.GameDTO;
import com.ggsilverio.dslist.dto.GameMinDTO;
import com.ggsilverio.dslist.entities.Game;
import com.ggsilverio.dslist.projections.GameMinProjection;
import com.ggsilverio.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {

        List<Game> gameList = gameRepository.findAll();
        return gameList.stream().map(x->new GameMinDTO(x)).toList();
    }
    @Transactional(readOnly = true)
    public GameDTO findById(Long id)
    {
        //findById retorna um optional e usando o .get() a gente consegue pegar apenas tipo Game
        Game entity = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(entity);
        return dto;
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> searchByList(Long id) {

        List<GameMinProjection> gameList = gameRepository.searchByList(id);
        return gameList.stream().map(x->new GameMinDTO(x)).toList();
    }



}
