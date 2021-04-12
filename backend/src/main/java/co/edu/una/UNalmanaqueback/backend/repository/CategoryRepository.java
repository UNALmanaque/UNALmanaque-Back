package co.edu.una.UNalmanaqueback.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.edu.una.UNalmanaqueback.backend.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{
}
