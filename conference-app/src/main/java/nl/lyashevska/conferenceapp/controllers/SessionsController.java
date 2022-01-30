package nl.lyashevska.conferenceapp.controllers;

import nl.lyashevska.conferenceapp.models.Session;
import nl.lyashevska.conferenceapp.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list(){
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id){

        return sessionRepository.getById(id);
    }

//    @PostMapping
//    // @ResponseStatus(HttpStatus.CREATED) // this maps to 201, othervise to 200
//    public Session create(@RequestBody final Session session){
//        return sessionRepository.saveAndFlush(session);
//    }

}
