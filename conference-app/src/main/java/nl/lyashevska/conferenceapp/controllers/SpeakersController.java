package nl.lyashevska.conferenceapp.controllers;

import nl.lyashevska.conferenceapp.models.Speaker;
import nl.lyashevska.conferenceapp.repositories.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {

    // give CRUD access
    @Autowired
    private SpeakerRepository speakerRepository;

    //return all speakers
    @GetMapping
    public List<Speaker> list(){
        return speakerRepository.findAll();
    }

    // return specific speaker
    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id){
        return speakerRepository.getById(id);
    }

//    @PostMapping
//    public Speaker create(@RequestBody final Speaker speaker){
//        return speakerRepository.saveAndFlush(speaker);
//    }


}
