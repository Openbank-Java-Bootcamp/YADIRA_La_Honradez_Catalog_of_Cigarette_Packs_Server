package com.ironhack.lahonradezserver.service.interfaces;

import com.ironhack.lahonradezserver.model.Serie;

import java.util.List;

public interface SerieServiceInterface {
    void saveSerial(Serie serie);
    List<Serie> getAllSeries();
    void updateSerial(Long id, Serie serie);
    Serie selectSerialById(Long id);
    void deleteSerial(Long id);
}

