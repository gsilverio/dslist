package com.ggsilverio.dslist.repositories;

import com.ggsilverio.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRespository extends JpaRepository<GameList, Long> {
}
