package co.simplon.cinemaapp.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.simplon.cinemaapp.model.Category;
import co.simplon.cinemaapp.model.Movie;
import co.simplon.cinemaapp.service.MovieService;

@RunWith(SpringRunner.class)
//@AutoConfigureMockMvc
//@WebMvcTest(MovieController.class) // permet de tester un seul contrôleur sans charger toute l'application
public class MovieControllerTest {
	
	@Autowired
    private MockMvc mvc;	// permet invoquer API Rest en permettant à Spring-Boot-Test de créer des objets (simulation de requêtes HTTP)

    /*
     *  Encapsulation de Mockito (Framework java pour des tests unitaires en remplaçant des dépendances par des Mocks)
     *  Mocks => Simulacres d'objets réels ! Cela va nous permettre de tester le contrôleur avec la couche HTTP.
     */
	@MockBean
    private MovieService movieService;
    
	// permet conversion des Objets en JSON comme si cela venait d'une API JavaScript.
    private ObjectMapper mapper = new ObjectMapper();
    
    @Test
    public void whenThenMovie() throws Exception {
    	
    	// 1.Given (condition)
//		Movie mockedItem = new Movie("La Belle Epoque", 155, new Category("dramatique"));
//
//        when(movieService.findBy("it1")).thenReturn(mockedItem);
//     
//        // 2.When (Quand)
//        String result = itemService.getItemNameUpperCase("it1");
//     
//        // 3.Then (alors)
//        verify(itemRepository, times(1)).findById("it1");
//        assertThat(result, is("ITEM 1"));
    	
    }

}
