package co.edu.una.UNalmanaqueback.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.edu.una.UNalmanaqueback.backend.model.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
}
