package co.simplon.cinemaapp;

import co.simplon.cinemaapp.model.AppUser;
import co.simplon.cinemaapp.model.Category;
import co.simplon.cinemaapp.model.Movie;
import co.simplon.cinemaapp.model.Role;
import co.simplon.cinemaapp.service.AppUserService;
import co.simplon.cinemaapp.service.CategoryService;
import co.simplon.cinemaapp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class CinemaAppApplication implements CommandLineRunner {

    @Autowired
    AppUserService userService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    MovieService movieService;

    public static void main(String[] args) {
        SpringApplication.run(CinemaAppApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Init method that loads some data in database.
     * @param params
     * @throws Exception
     */
    @Override
    public void run(String... params) throws Exception {
        AppUser admin = new AppUser("jgrand", "iamgroot", new ArrayList<>(Arrays.asList(Role.ROLE_ADMIN, Role.ROLE_CREATOR, Role.ROLE_READER)));
        userService.signup(admin);

        AppUser user = new AppUser("jtobelem", "bonnequestion", new ArrayList<>(Arrays.asList(Role.ROLE_CREATOR, Role.ROLE_READER)));
        userService.signup(user);

        Category cultMovie = new Category("Film culte");
        Category horribleMovie = new Category("Film naze");

        cultMovie = categoryService.createNewCategory(cultMovie);
        horribleMovie = categoryService.createNewCategory(horribleMovie);

        Movie dikkenek = new Movie("Dikkenek", 92, cultMovie);
        Movie lordOfTheRigns = new Movie("La communauté de l'anneau", 180, cultMovie);
        Movie batmanVsSuperman = new Movie("Batman vs Superman", 130, horribleMovie);

        movieService.createNewMovie(dikkenek);
        movieService.createNewMovie(lordOfTheRigns);
        movieService.createNewMovie(batmanVsSuperman);

    }

}
