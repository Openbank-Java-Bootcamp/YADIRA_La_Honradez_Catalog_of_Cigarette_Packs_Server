package com.ironhack.lahonradezserver.service.impl;

import com.ironhack.lahonradezserver.model.Serie;
import com.ironhack.lahonradezserver.repository.SerieRepository;
import com.ironhack.lahonradezserver.service.interfaces.SerieServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SerieService implements SerieServiceInterface {

    @Autowired
    private SerieRepository serieRepository;

    @Override
    public List<Serie> getAllSeries() {
        return serieRepository.findAll();
    }

    @Override
    public Serie selectSerialById(Long id) {
        return serieRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serial not found"));
    }

    @Override
    public void saveSerial(Serie serie) {
        if(serie.getId() != null){
            Optional<Serie> serialOp = serieRepository.findById(serie.getId());
            if(serialOp.isPresent()){
                log.error("The Serie whit the id" + serie.getId() + "already exist");
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "The Serie whit the id" + serie.getId() + "already exist");
            }
        }
        if(serieRepository.findByTitleS(serie.getTitleS()) != null){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "The Serie with the title" + serie.getTitleS() + "already exist");
        }
        serieRepository.save(serie);
    }

    @Override
    public void updateSerial(Long id, Serie serie) {
        Serie serieDB = serieRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serial not found"));
        serie.setId(serieDB.getId());
        serieRepository.save(serie);
    }

    @Override
    public void deleteSerial(Long id) {
        Serie serieDB = serieRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serial not found"));
        serieRepository.deleteById(id);
    }
}
