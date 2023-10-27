package com.dfm.DFManager.service;

import com.dfm.DFManager.model.Club;
import com.dfm.DFManager.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {

    @Autowired
    private final ClubRepository clubRepository;


    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }


    public Club findById(Long id) {
        return clubRepository.getOne(id);
    }
    public List<Club> findAll() {
        return clubRepository.findAll();
    }
    public Club saveClub(Club club) {
        return clubRepository.save(club);
    }
    public void deleteById(Long id) {
        clubRepository.deleteById(id);
    }
}
