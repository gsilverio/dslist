package com.ggsilverio.dslist.controllers;

import com.ggsilverio.dslist.dto.GameDTO;
import com.ggsilverio.dslist.dto.GameListDTO;
import com.ggsilverio.dslist.dto.GameMinDTO;
import com.ggsilverio.dslist.entities.GameList;
import com.ggsilverio.dslist.service.GameListService;
import com.ggsilverio.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;
    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAll(){
        List<GameListDTO> listDTO = gameListService.findAll();
        return ResponseEntity.ok().body(listDTO);
    }
    @GetMapping(value = "/{id}/games")
    public ResponseEntity<List<GameMinDTO>> searchByList(@PathVariable Long id){
        List<GameMinDTO> listDTO = gameService.searchByList(id);
        return ResponseEntity.ok().body(listDTO);
    }


}
