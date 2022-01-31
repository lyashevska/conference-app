package nl.lyashevska.conferenceapp.controllers;

import nl.lyashevska.conferenceapp.models.Session;
import nl.lyashevska.conferenceapp.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Full CRUD controller for the session
 */
@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {

    @Autowired
    private SessionRepository sessionRepository;

    // list
    @GetMapping
    public List<Session> list(){
        return sessionRepository.findAll();
    }

    // get
    // require http get
    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id){

        return sessionRepository.getById(id);
    }

    // create
    // require http post
    @PostMapping
    // @ResponseStatus(HttpStatus.CREATED) // this maps to 201, othervise to 200
    // take all attributes in json payload and auto marshal to session object
    // then pass to a session repo
    public Session create(@RequestBody final Session session){
        return sessionRepository.saveAndFlush(session);
    }

    // delete endpoint
    // http verb delete is present
    @RequestMapping(value = "{id}, method = RequestMethod.DELETE")
    public void delete(@PathVariable Long id){
        // also need to check for children recodrs before deleting
        sessionRepository.deleteById(id);
    }

    // update
    // session record
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session){
        // because this is PUT we axpect all attributes to be passed in, othervise they get 0
        // A PATCH would only update what you need to update
        // TODO: Add validation that all attributed are passed in, othervise return a 400 bad payload
        // find existing record from url
        Session existingSession = sessionRepository.getById(id);
        // takes the existing session and copies data onto it, except for session_id
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }
}
