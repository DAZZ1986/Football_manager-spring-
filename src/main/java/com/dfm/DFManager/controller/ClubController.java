package com.dfm.DFManager.controller;


import com.dfm.DFManager.model.Club;
import com.dfm.DFManager.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClubController {
    @Autowired
    private ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public String findAll(Model model) {
        List<Club> clubs = clubService.findAll();
        model.addAttribute("clubsAtt", clubs);
        return "club-list";
    }

    @GetMapping("/club-create")
    public String clubFromoCreate(Model model) {
        Club club = new Club();
        club.setClubName("default name");
        model.addAttribute("clubObjParamCreate", club);
        return "club-create";
    }
    @PostMapping("/club-create")
    public String clubCreate(Club clubObjParam) {
        clubService.saveClub(clubObjParam);
        return "redirect:/clubs";
    }



    @GetMapping("club-delete/{id}")
    public String deleteClub(@PathVariable("id") Long id) {
        clubService.deleteById(id);
        return "redirect:/clubs";
    }



    @GetMapping("/club-update/{id}")
    public String updateClubFrom(@PathVariable("id") Long id, Model model) {
        Club club = clubService.findById(id);
        model.addAttribute("clubObjParamUpdate", club);
        return "/club-update";
    }
    @PostMapping("/club-update")
    public String updateClub(Club clubObjParam) {
        clubService.saveClub(clubObjParam);
        return "redirect:/clubs";
    }


}
