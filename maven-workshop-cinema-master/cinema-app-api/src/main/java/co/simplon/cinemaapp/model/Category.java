package co.simplon.cinemaapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Movie category entity.
 * e.g.: "Film culte", "Film naze", ...
 */
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Movie> movieList = new ArrayList<>();

    private Category() {
    }

    public Category(@NotNull String name) {
        this.name = name;
    }

    public Category(@NotNull String name, List<Movie> movieList) {
        this.name = name;
        this.movieList = movieList;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }
}
