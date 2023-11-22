package com.ggsilverio.dslist.service;

import com.ggsilverio.dslist.dto.GameDTO;
import com.ggsilverio.dslist.dto.GameListDTO;
import com.ggsilverio.dslist.dto.GameMinDTO;
import com.ggsilverio.dslist.entities.Game;
import com.ggsilverio.dslist.entities.GameList;
import com.ggsilverio.dslist.projections.GameMinProjection;
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
    @Autowired
    private GameRepository gameRepository;
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> gameList = gameListRespository.findAll();
        return gameList.stream().map(x->new GameListDTO(x)).toList();
    }
    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex)
    {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex > destinationIndex ? sourceIndex : destinationIndex;

        for(int i = min; i<=max; i++)
        {
            gameListRespository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }

}
