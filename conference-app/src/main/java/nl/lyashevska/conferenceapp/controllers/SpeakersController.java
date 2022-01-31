package nl.lyashevska.conferenceapp.controllers;

import nl.lyashevska.conferenceapp.models.Session;
import nl.lyashevska.conferenceapp.models.Speaker;
import nl.lyashevska.conferenceapp.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {

    // give CRUD access
    // create an instance of the session repo and add to the class
    @Autowired
    private SpeakerRepository speakerRepository;

    //return all speakers
    @GetMapping
    public List<Speaker> list(){
        return speakerRepository.findAll();
    }

    // return specific speaker
    // http get mapping
    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id){
        return speakerRepository.getById(id);
    }

    // create
    @PostMapping
    public Speaker create(@RequestBody final Speaker speaker){
        return speakerRepository.saveAndFlush(speaker);
    }

    // update
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker){
        // because this is PUT we axpect all attributes to be passed in, othervise they get 0
        // A PATCH would only update what you need to update
        // TODO: Add validation that all attributed are passed in, othervise return a 400 bad payload
        // find existing record from url
        Speaker existingSpeaker = speakerRepository.getById(id);
        // takes the existing session and copies data onto it, except for speaker_id
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }

    // delete endpoint
    // http verb delete is present
    @RequestMapping(value = "{id}, method = RequestMethod.DELETE")
    public void delete(@PathVariable Long id){
        // also need to check for children recodrs before deleting
        speakerRepository.deleteById(id);
    }

}
