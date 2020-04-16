package co.simplon.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
