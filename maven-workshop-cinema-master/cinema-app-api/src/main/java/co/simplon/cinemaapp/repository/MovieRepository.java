package co.simplon.cinemaapp.repository;

import co.simplon.cinemaapp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	Movie findByName(String name);

}
