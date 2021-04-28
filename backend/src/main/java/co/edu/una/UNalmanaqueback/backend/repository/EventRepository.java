package co.edu.una.UNalmanaqueback.backend.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.edu.una.UNalmanaqueback.backend.model.Event;
import co.edu.una.UNalmanaqueback.backend.repository.EventRepository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
    @Query("SELECT u FROM Event u WHERE u.user = ?1")
    Iterable<Event> getEventsByUser(String userEmail);
    @Modifying
    @Query("DELETE FROM Event e WHERE e.eventId = ?1")
    Integer findEventsByEventId(Integer eventId);
}
