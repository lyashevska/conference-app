package nl.lyashevska.conferenceapp.repositories;

import nl.lyashevska.conferenceapp.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
