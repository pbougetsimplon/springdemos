package co.simplon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.model.Movie;
import co.simplon.repository.MovieRepository;

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
    
    public Movie findByName(String name)
    {
    	return movieRepository.findByName(name);
    }

	@Override
	public void deleteMovie(Long id) {
		this.movieRepository.delete(this.movieRepository.getOne(id));
		
	}
}
