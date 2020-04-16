package co.simplon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
