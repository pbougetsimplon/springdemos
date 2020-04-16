package co.simplon;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import co.simplon.model.AppUser;
import co.simplon.model.Category;
import co.simplon.model.Movie;
import co.simplon.model.Role;
import co.simplon.service.AppUserService;
import co.simplon.service.CategoryService;
import co.simplon.service.MovieService;

@SpringBootApplication
public class CinemaBackApiApplication implements CommandLineRunner {

    @Autowired
    AppUserService userService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    MovieService movieService;

    public static void main(String[] args) {
        SpringApplication.run(CinemaBackApiApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Methode pour charger les données dans la BD
     * @param params
     * @throws Exception
     */
    @Override
    public void run(String... params) throws Exception {
    	
        AppUser admin = new AppUser("jgrand", "jgrand12", new ArrayList<>(Arrays.asList(Role.ROLE_ADMIN, Role.ROLE_CREATOR, Role.ROLE_READER)));
        userService.signup(admin);
        
        AppUser pb = new AppUser("pbouget", "pbouget34", new ArrayList<>(Arrays.asList(Role.ROLE_ADMIN, Role.ROLE_CREATOR, Role.ROLE_READER)));
        userService.signup(pb);

        AppUser user = new AppUser("jtobelem", "jtobelem56", new ArrayList<>(Arrays.asList(Role.ROLE_CREATOR, Role.ROLE_READER)));
        userService.signup(user);

        Category cultMovie = new Category("Film culte");
        Category horribleMovie = new Category("Film naze");

        cultMovie = categoryService.createNewCategory(cultMovie);
        horribleMovie = categoryService.createNewCategory(horribleMovie);

        Movie dikkenek = new Movie("Dikkenek", 92, cultMovie);
        Movie lordOfTheRigns = new Movie("La communauté de l'anneau", 180, cultMovie);
        Movie batmanVsSuperman = new Movie("Batman vs Superman", 130, horribleMovie);
        Movie covid19 = new Movie("Covid-19",156, horribleMovie);

        movieService.createNewMovie(dikkenek);
        movieService.createNewMovie(lordOfTheRigns);
        movieService.createNewMovie(batmanVsSuperman);
        movieService.createNewMovie(covid19);

    }

}
