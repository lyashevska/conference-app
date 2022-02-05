package org.example.repository;

import org.example.model.Speaker;

import java.util.ArrayList;
import java.util.List;

public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {
    @Override
    public List<Speaker> findAll(){
        List<Speaker> speakers = new ArrayList<Speaker>();
        Speaker speaker = new Speaker();

        speaker.setFirstName("olga");
        speaker.setLastName("Lya");

        speakers.add(speaker);
        return speakers;
    }
}
