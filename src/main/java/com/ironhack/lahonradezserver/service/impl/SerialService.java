package com.ironhack.lahonradezserver.service.impl;

import com.ironhack.lahonradezserver.model.Serie;
import com.ironhack.lahonradezserver.repository.SerialRepository;
import com.ironhack.lahonradezserver.service.interfaces.SerialServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SerialService implements SerialServiceInterface {

    @Autowired
    private SerialRepository serialRepository;

    @Override
    public List<Serie> getAllSeries() {
        return serialRepository.findAll();
    }

    @Override
    public Serie selectSerialById(Long id) {
        return serialRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serial not found"));
    }

    @Override
    public void saveSerial(Serie serie) {
        if(serie.getId() != null){
            Optional<Serie> serialOp = serialRepository.findById(serie.getId());
            if(serialOp.isPresent()){
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "The Serial already exist");
            }
        }
        serialRepository.save(serie);
    }

    @Override
    public void updateSerial(Long id, Serie serie) {
        Serie serieDB = serialRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serial not found"));
        serie.setId(serieDB.getId());
        serialRepository.save(serie);
    }

    @Override
    public void deleteSerial(Long id) {
        Serie serieDB = serialRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serial not found"));
        serialRepository.deleteById(id);
    }
}
