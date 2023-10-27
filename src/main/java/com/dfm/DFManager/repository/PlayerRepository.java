package com.dfm.DFManager.repository;

import com.dfm.DFManager.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
