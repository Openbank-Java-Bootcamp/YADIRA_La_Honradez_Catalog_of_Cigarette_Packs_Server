package com.ironhack.lahonradezserver.controller;

import com.ironhack.lahonradezserver.DTO.CigarettePackDTO;
import com.ironhack.lahonradezserver.model.CigarettePack;
import com.ironhack.lahonradezserver.service.impl.CigarettePackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CigarettePackController {

    @Autowired
    private CigarettePackService cigarettePackService;

    @GetMapping("/cigarette_packs")
    @ResponseStatus(HttpStatus.OK)
    public List<CigarettePackDTO> getACigarettePacks(@RequestParam Optional<String> topic, @RequestParam Optional<String> serieName) {
        if(topic.isPresent()){
            return cigarettePackService.getCigarettePacksByTopic(topic.get());
        } else if (serieName.isPresent()){
            return cigarettePackService.getCigarettePacksBySerie(serieName.get());
        } else {
            return cigarettePackService.getAllCigarettePack();
        }
    }

    @GetMapping("/cigarette_packs/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CigarettePack selectCigarettePackById(@PathVariable Long id){
        return cigarettePackService.selectCigarettePackById(id);
    }

    @PostMapping("/cigarette_packs")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCigarettePack(@RequestBody @Valid CigarettePackDTO cigarettePackDTO){
        cigarettePackService.saveCigarettePack(cigarettePackDTO);
    }

    @PutMapping("/cigarette_packs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCigarettePack(@PathVariable Long id, @RequestBody @Valid CigarettePack cigarettePack){
        cigarettePackService.updateCigarettePack(id, cigarettePack);
    }

    @DeleteMapping("/cigarette_packs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCigarettePack(@PathVariable  Long id){
        cigarettePackService.deleteCigarettePack(id);
    }
}



