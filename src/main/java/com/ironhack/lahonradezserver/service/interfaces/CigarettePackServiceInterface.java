package com.ironhack.lahonradezserver.service.interfaces;

import com.ironhack.lahonradezserver.DTO.CigarettePackDTO;
import com.ironhack.lahonradezserver.model.CigarettePack;
import com.ironhack.lahonradezserver.model.Serie;

import java.util.List;

public interface CigarettePackServiceInterface {
    void saveCigarettePack(CigarettePackDTO cigarettePackDTO);
    CigarettePackDTO selectCigarettePackById(Long id);
    void updateCigarettePack(Long id, CigarettePackDTO cigarettePackDTO);
    void deleteCigarettePack(Long id);
    List<CigarettePackDTO> getAllCigarettePack();
    List<CigarettePackDTO> getCigarettePacksByTopic(String topicId);
    List<CigarettePackDTO> getCigarettePacksBySerie(String serieName);

}
