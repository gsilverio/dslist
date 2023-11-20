package com.ggsilverio.dslist.service;

import com.ggsilverio.dslist.dto.GameDTO;
import com.ggsilverio.dslist.dto.GameListDTO;
import com.ggsilverio.dslist.dto.GameMinDTO;
import com.ggsilverio.dslist.entities.Game;
import com.ggsilverio.dslist.entities.GameList;
import com.ggsilverio.dslist.repositories.GameListRespository;
import com.ggsilverio.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRespository gameListRespository;
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> gameList = gameListRespository.findAll();
        return gameList.stream().map(x->new GameListDTO(x)).toList();
    }

}
