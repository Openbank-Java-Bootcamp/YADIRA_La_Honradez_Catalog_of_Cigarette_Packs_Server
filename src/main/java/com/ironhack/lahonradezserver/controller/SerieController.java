package com.ironhack.lahonradezserver.controller;

import com.ironhack.lahonradezserver.model.Serie;
import com.ironhack.lahonradezserver.service.impl.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SerieController {

    @Autowired
    private SerieService serialService;

    @GetMapping("/series")
    @ResponseStatus(HttpStatus.OK)
    public List<Serie> getAllSeries(){
        return serialService.getAllSeries();
    }

    @GetMapping("/series/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Serie selectSerialById(@PathVariable Long id) {
        return serialService.selectSerialById(id);
    }

    @PostMapping("/series")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSerial(@RequestBody @Valid Serie serie){
        serialService.saveSerial(serie);
    }

    @PutMapping("/series/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateSerial(@PathVariable Long id, @RequestBody @Valid Serie serie){
        serialService.updateSerial(id, serie);
    }

    @DeleteMapping("/series/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteSerial(@PathVariable Long id){
        serialService.deleteSerial(id);
    }
}
