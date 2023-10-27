package com.dfm.DFManager.service;

import com.dfm.DFManager.model.Player;
import com.dfm.DFManager.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private final PlayerRepository playerRepository;


    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    public Player findById(Long id) {
        return playerRepository.getOne(id);
    }
    public List<Player> findAll() {
        return playerRepository.findAll();
    }
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }
    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }

}
