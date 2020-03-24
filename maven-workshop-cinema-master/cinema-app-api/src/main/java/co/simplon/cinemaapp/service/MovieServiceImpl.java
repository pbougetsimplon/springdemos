package co.simplon.cinemaapp.service;

import co.simplon.cinemaapp.model.Movie;
import co.simplon.cinemaapp.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie createNewMovie(Movie newMovie) {
        return movieRepository.save(newMovie);
    }
}
