package com.ironhack.lahonradezserver.service.impl;

import com.ironhack.lahonradezserver.DTO.CigarettePackDTO;
import com.ironhack.lahonradezserver.model.CigarettePack;
import com.ironhack.lahonradezserver.model.Serie;
import com.ironhack.lahonradezserver.model.Topic;
import com.ironhack.lahonradezserver.repository.CigarettePackRepository;
import com.ironhack.lahonradezserver.repository.SerieRepository;
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
    private SerieRepository serieRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public List<CigarettePackDTO> getAllCigarettePack() {
        List<CigarettePackDTO> cigPackDTOList = new ArrayList<>();
        List<CigarettePack> allCigPacksDB= cigarettePackRepository.findAll();

        for(CigarettePack cigPackDB : allCigPacksDB) {

            List<String> topicsNames = new ArrayList<>();
            List<Topic> topics = cigPackDB.getTopics();
            for(Topic topic : topics){
                topicsNames.add(topic.getName());
            }

            String serieName = cigPackDB.getSerie().getTitleS();
            CigarettePackDTO cigPackDTO = new CigarettePackDTO(
                    cigPackDB.getId(),
                    cigPackDB.getTitleCP(),
                    cigPackDB.getDescriptionCP(),
                    cigPackDB.getLink(),
                    topicsNames,
                    serieName
            );

            cigPackDTOList.add(cigPackDTO);
        }

        return cigPackDTOList;
    }

    @Override
    public List<CigarettePackDTO> getCigarettePacksByTopic(String topic) {
        List<CigarettePackDTO> filteredCigPack = new ArrayList<>();

        List<CigarettePackDTO> cigarettePacks = getAllCigarettePack();
        for (CigarettePackDTO cigPak : cigarettePacks) {
            for(String topicDB : cigPak.getTopics()) {
                if(topic.equals(topicDB)){
                    filteredCigPack.add(cigPak);
                }
            }
        }
        return filteredCigPack;
    }

    @Override
    public List<CigarettePackDTO> getCigarettePacksBySerie(String serieName) {
        List<CigarettePackDTO> filteredCigPack = new ArrayList<>();
        List<CigarettePackDTO> cigarettePacks = getAllCigarettePack();
        for (CigarettePackDTO cigPak : cigarettePacks) {
            if(cigPak.getSerieName().equals(serieName)){
                filteredCigPack.add(cigPak);
            }
        }
        return filteredCigPack;
    }

    @Override
    public List<CigarettePackDTO> getCigarettePacksByTopicAndFilter(String topic, String serieName) {
        List<CigarettePackDTO> filteredByTopicAndSerie = new ArrayList<>();
        List<CigarettePackDTO> filteredByTopic = getCigarettePacksByTopic(topic);
        for (CigarettePackDTO cigPack : filteredByTopic) {
            if(cigPack.getSerieName().equals(serieName)){
                filteredByTopicAndSerie.add(cigPack);
            }
        }
        return filteredByTopicAndSerie;
    }

    @Override
    public CigarettePackDTO selectCigarettePackById(Long id) {

        CigarettePack cigPackDB = cigarettePackRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cigarette Pack not found"));

        List<String> topicsNames = new ArrayList<>();
        List<Topic> topics = cigPackDB.getTopics();
        for(Topic topic : topics){
            topicsNames.add(topic.getName());
        }

        String serieName = cigPackDB.getSerie().getTitleS();
        CigarettePackDTO cigPackDTO = new CigarettePackDTO(
                cigPackDB.getId(),
                cigPackDB.getTitleCP(),
                cigPackDB.getDescriptionCP(),
                cigPackDB.getLink(),
                topicsNames,
                serieName
        );

        return cigPackDTO;
    }

    @Override
    public void saveCigarettePack(CigarettePackDTO cigarettePackDTO) {
        if(cigarettePackRepository.findByTitleCP(cigarettePackDTO.getTitle()) != null){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "The Serie with the title" + cigarettePackDTO.getTitle() + "already exist");
        }
        CigarettePack newCigarettePack = new CigarettePack();
        newCigarettePack.setTitleCP(cigarettePackDTO.getTitle());
        newCigarettePack.setDescriptionCP(cigarettePackDTO.getDescription());
        newCigarettePack.setLink(cigarettePackDTO.getLink());
        newCigarettePack.setSerie(serieRepository.findByTitleS(cigarettePackDTO.getSerieName()));

        List<Topic> topics = new ArrayList<>();
        //topics = topicRepository.findAllById(cigarettePackDTO.getTopics());
        for (String topicName : cigarettePackDTO.getTopics()) {
            Topic topic = topicRepository.findByName(topicName);
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
    public void updateCigarettePack(Long id, CigarettePackDTO cigarettePackDTO) {
        CigarettePack cigarettePackDB = cigarettePackRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cigarette Pack not found"));
        Serie serie = serieRepository.findByTitleS(cigarettePackDTO.getSerieName());
        List<Topic> topics = new ArrayList<>();
        for (String topicName : cigarettePackDTO.getTopics()) {
            Topic topic = topicRepository.findByName(topicName);
            topics.add(topic);
        }
        CigarettePack modifiedCigPack = new CigarettePack(
                id,
                cigarettePackDTO.getTitle(),
                cigarettePackDTO.getDescription(),
                cigarettePackDTO.getLink(),
                serie,
                topics
        );

        cigarettePackRepository.save(modifiedCigPack);
    }

    @Override
    public void deleteCigarettePack(Long id) {
        CigarettePack cigarettePack1DB = cigarettePackRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cigarette Pack not found"));
        cigarettePackRepository.deleteById(id);
    }




}
