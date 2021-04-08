package co.edu.una.UNalmanaqueback.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.edu.una.UNalmanaqueback.backend.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
