package nl.lyashevska.conferenceapp.repositories;

import nl.lyashevska.conferenceapp.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
