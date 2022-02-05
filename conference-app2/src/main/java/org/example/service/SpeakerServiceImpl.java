package org.example.service;

import org.example.model.Speaker;
import org.example.repository.HibernateSpeakerRepositoryImpl;
import org.example.repository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

    private SpeakerRepository repository = new HibernateSpeakerRepositoryImpl();

    @Override
    public List<Speaker> findAll(){
        return repository.findAll();

    }
}
