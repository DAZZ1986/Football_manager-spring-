package com.dfm.DFManager.controller;

import com.dfm.DFManager.model.Player;
import com.dfm.DFManager.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PlayerController {
    @Autowired
    private PlayerService playerService;


    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }




    @GetMapping("/players")         //ссылка в браузере и вход в контроллер
    public String findAll(Model model) {
        List<Player> players = playerService.findAll();
        model.addAttribute("playersAtt", players);
        return "player-list";       //ссылка которая будет отображаться по факту (html page)
    }




    @GetMapping("/player-create")
    public String createPlayerForm(Player playerObjParamCreate, Model model) {
        Player player = new Player();
        player.setFirstNameC("default name");
        player.setLastNameC("default last name");
        model.addAttribute("playerObjParamCreate", player);
        return "/player-create";
    }
    @PostMapping("/player-create")
    public String createPlayer(Player playerObjParamCr) {
        playerService.savePlayer(playerObjParamCr);
        return "redirect:/players";
    }




    @GetMapping("/player-delete/{id}")
    public String deletePlayer(@PathVariable("id") Long id) {
        playerService.deleteById(id);
        return "redirect:/players";
    }




    @GetMapping("/player-update/{id}")
    public String updatePlayerForm(@PathVariable("id") Long id, Model model) {
        Player player = playerService.findById(id);
        model.addAttribute("playerObjParamUpdate", player);
        return "/player-update";
    }
    @PostMapping("/player-update")  //тут в урл id писать не нужно, тк вероятно мы уже на данной странице, и POST запрос был отправлен с нее и мы суда же при POST запросе и попадем.
    public String updatePlayer(Player playerObjParamUp) {
        playerService.savePlayer(playerObjParamUp);
        return "redirect:/players";
    }

}
