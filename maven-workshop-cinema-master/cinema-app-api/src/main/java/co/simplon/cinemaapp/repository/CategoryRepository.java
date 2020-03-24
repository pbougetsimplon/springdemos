package co.simplon.cinemaapp.repository;

import co.simplon.cinemaapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
