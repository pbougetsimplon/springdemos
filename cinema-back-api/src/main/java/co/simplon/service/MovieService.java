package co.simplon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.model.Movie;

@Service
public interface MovieService {

    /**
     * Method that lists all existing movies from database.
     * @return the list of all existing movies.
     */
    List<Movie> findAllMovies();

    /**
     * Method that creates a new movie.
     * @param newMovie the new movie to create.
     * @return the new created movie.
     */
    Movie createNewMovie(Movie newMovie);
    
    /**
     * Méthode qui retourne un film en le cherchant par son titre
     * @param name
     * @return
     */
    Movie findByName(String name);
    
    /**
     * Méthode qui détruit un Movie
     * @param movie
     */
    void deleteMovie(Long id);
    
}
