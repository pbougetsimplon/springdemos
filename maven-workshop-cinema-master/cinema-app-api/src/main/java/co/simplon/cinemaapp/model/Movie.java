package co.simplon.cinemaapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Movie entity.
 * e.g.: "La cité de la peur", "Dikkenek", "Robin des bois", ...
 */
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private Integer duration;

    @ManyToOne
    private Category category;

    private Movie() {
    }

    public Movie(@NotNull String name, @NotNull Integer duration, Category category) {
        this.name = name;
        this.duration = duration;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getDuration() {
        return duration;
    }

    public Category getCategory() {
        return category;
    }
}
