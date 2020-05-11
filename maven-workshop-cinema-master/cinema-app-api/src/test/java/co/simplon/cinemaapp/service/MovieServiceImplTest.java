package co.simplon.cinemaapp.service;

import static org.mockito.Mockito.when;

//import org.assertj.core.api.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import co.simplon.cinemaapp.model.Movie;
import co.simplon.cinemaapp.repository.CategoryRepository;
import co.simplon.cinemaapp.repository.MovieRepository;

@RunWith(SpringRunner.class) // permet de faire le lien entre SpringBoot et JUnit
@DataJpaTest				 // permet de fournir le setup pour tester Hibernate et JPA
//@AutoConfigureTestDatabase
@WebMvcTest(MovieServiceImpl.class) // permet de tester sans charger toute l'application
public class MovieServiceImplTest {

//	@Autowired
//    private MockMvc mvc;	// permet invoquer API Rest en permettant à Spring-Boot-Test de créer des objets (simulation de requêtes HTTP)

	@MockBean
	private MovieRepository movieRepository;

	@MockBean
	private CategoryRepository categoryRepository;

	@Test
	public void whenFindByName_thenReturnMovie() {
		// on inject un film avec une categorie

		// 1.Given (condition)
	//	Movie mockedItem = new Movie("La Belle Epoque", 155, new Category("dramatique"));
		Movie mockedItem = movieRepository.findByName("Dikkenek");
		// 2.When (Quand) / Then (Alors)
		when(movieRepository.findByName("Dikkenek")).thenReturn(mockedItem);

		when(movieRepository.findByName("La Belle Epique")).thenThrow(new Exception("name introuvable"));
	
//		String result = itemService.getItemNameUpperCase("it1");

		// 3.Then (alors)
//		verify(itemRepository, times(1)).findById("it1");
//		assertThat(result, is("ITEM 1"));



		//		Category dramatique = new Category("dramatique");
		//		categoryRepository.save(dramatique);
		////		entityManager.persist(dramatique);
		////		entityManager.flush();
		//		
		//		// public Movie(@NotNull String name, @NotNull Integer duration, Category category)
		//		Movie laBelleEpoque = new Movie("La Belle Epoque", 155, dramatique);
		//		movieRepository.save(laBelleEpoque);
		////	    entityManager.persist(laBelleEpoque);
		////	    entityManager.flush();
		//	 
		//	    Movie trouve = movieRepository.findByName(laBelleEpoque.getName());
		//	 
		//	 //   when()
		//	    
		//	    // then (alors)
		//	    assertThat(trouve.getName(), is(equalTo("La Belle Epoque")));
		//	    
		//	    assertThat(trouve.getName(), is(equalTo("La Belle Epique")));

	}
}
