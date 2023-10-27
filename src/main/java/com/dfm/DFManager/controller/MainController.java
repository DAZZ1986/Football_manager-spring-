package com.dfm.DFManager.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("list")
@Controller
public class MainController {

    @GetMapping
    public String mainMenu() {
        return "main-menu";       //ссылка которая будет отображаться по факту (html page)
    }
    @GetMapping("/users")         //ссылка в браузере и вход в контроллер
    public String usersMenu() {
        return "user-list";       //ссылка которая будет отображаться по факту (html page)
    }
    @GetMapping("/players")
    public String playersMenu() {
        return "player-list";
    }
    @GetMapping("/clubs")
    public String clubsMenu() {
        return "club-list";
    }

}
