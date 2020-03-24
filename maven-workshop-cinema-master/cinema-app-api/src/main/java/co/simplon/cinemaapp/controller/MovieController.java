package co.simplon.cinemaapp.controller;

import co.simplon.cinemaapp.model.Movie;
import co.simplon.cinemaapp.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        // TODO: Error handling
        return ResponseEntity.ok(movieService.createNewMovie(newMovie));
    }
}
