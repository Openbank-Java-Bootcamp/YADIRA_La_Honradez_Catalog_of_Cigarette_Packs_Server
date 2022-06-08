package com.ironhack.lahonradezserver.service.interfaces;

import com.ironhack.lahonradezserver.DTO.CigarettePackDTO;
import com.ironhack.lahonradezserver.model.CigarettePack;

import java.util.List;

public interface CigarettePackServiceInterface {
    void saveCigarettePack(CigarettePackDTO cigarettePackDTO);
    CigarettePack selectCigarettePackById(Long id);
    void updateCigarettePack(Long id, CigarettePack cigarettePack);
    void deleteCigarettePack(Long id);
    List<CigarettePack> getAllCigarettePack();
}
