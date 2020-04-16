package co.simplon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	Movie findByName(String name);

}
