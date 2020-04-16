package co.simplon.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.model.Movie;
import co.simplon.service.MovieService;

/**
 * This controller is in charge of responding to http calls on /api/movie.
 * It can provide movie related data to authenticated users. Creator or Admin users may create new categories.
 */
@RestController
@RequestMapping("/api/movie")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * Method to list all the movies.
     * This method is restricted to authenticated users.
     * @return the list of movies from the database.
     */
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.findAllMovies();
    }

    /**
     * Method to create a new movie.
     * This method is restricted to Admin or Creator users.
     * @param newMovie the new movie to create.
     * @return the new created movie.
     */
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CREATOR')")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie newMovie) {
         return ResponseEntity.ok(movieService.createNewMovie(newMovie));
    }
    
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CREATOR')")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id) {

    	try {
    		this.movieService.deleteMovie(id);
			return ResponseEntity.ok("ok");
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
    	
	}
    
}
