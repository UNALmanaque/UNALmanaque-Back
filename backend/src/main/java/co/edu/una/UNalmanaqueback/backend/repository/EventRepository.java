package co.edu.una.UNalmanaqueback.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.edu.una.UNalmanaqueback.backend.model.Event;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
    @Query("SELECT u FROM Event u WHERE u.events = ?1")
    List<Event> getEventsByUser(Integer userId);
}
