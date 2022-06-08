package com.ironhack.lahonradezserver.service.impl;

import com.ironhack.lahonradezserver.DTO.CigarettePackDTO;
import com.ironhack.lahonradezserver.model.CigarettePack;
import com.ironhack.lahonradezserver.model.Topic;
import com.ironhack.lahonradezserver.repository.CigarettePackRepository;
import com.ironhack.lahonradezserver.repository.SerialRepository;
import com.ironhack.lahonradezserver.repository.TopicRepository;
import com.ironhack.lahonradezserver.service.interfaces.CigarettePackServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CigarettePackService implements CigarettePackServiceInterface {

    @Autowired
    private CigarettePackRepository cigarettePackRepository;

    @Autowired
    private SerialRepository serialRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public List<CigarettePack> getAllCigarettePack() {
        return cigarettePackRepository.findAll();
    }

    @Override
    public CigarettePack selectCigarettePackById(Long id) {
        return cigarettePackRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cigarette Pack not found"));

    }

    @Override
    public void saveCigarettePack(CigarettePackDTO cigarettePackDTO) {
        CigarettePack newCigarettePack = new CigarettePack();
        newCigarettePack.setTitleCP(cigarettePackDTO.getTittle());
        newCigarettePack.setDescriptionCP(cigarettePackDTO.getDescription());
        newCigarettePack.setLink(cigarettePackDTO.getLink());
        newCigarettePack.setSerie(serialRepository.findById(cigarettePackDTO.getSerialId()).get());

        List<Topic> topics = new ArrayList<>();
        //topics = topicRepository.findAllById(cigarettePackDTO.getTopics());
        for (Long topicId : cigarettePackDTO.getTopics()) {
            Topic topic = topicRepository.findById(topicId).get();
            topics.add(topic);
        }

        newCigarettePack.setTopics(topics);

        if(newCigarettePack.getId() != null) {
            Optional<CigarettePack> cigarettePackOp = cigarettePackRepository.findById(newCigarettePack.getId());
            if(cigarettePackOp.isPresent()){
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Cigarette Pack not found");
            }
        }
        cigarettePackRepository.save(newCigarettePack);
    }

    @Override
    public void updateCigarettePack(Long id, CigarettePack cigarettePack) {
        CigarettePack cigarettePack1DB = cigarettePackRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cigarette Pack not found"));
        cigarettePack.setId(cigarettePack1DB.getId());
        cigarettePackRepository.save(cigarettePack);
    }

    @Override
    public void deleteCigarettePack(Long id) {
        CigarettePack cigarettePack1DB = cigarettePackRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cigarette Pack not found"));
        cigarettePackRepository.deleteById(id);
    }


}
