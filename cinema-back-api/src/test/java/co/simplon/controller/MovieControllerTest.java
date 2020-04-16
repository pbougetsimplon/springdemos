package co.simplon.controller;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.simplon.model.Category;
import co.simplon.model.Movie;
import co.simplon.service.CategoryService;
import co.simplon.service.MovieService;

@RunWith(SpringRunner.class) // avec JUnit4
//@ExtendWith(SpringExtension.class) // avec Junit 5
@SpringBootTest
@ContextConfiguration
@AutoConfigureMockMvc
public class MovieControllerTest {

	@Autowired
	MockMvc mockMvc;
		
	@Autowired // il va convertir nos données en JSON lorsque nous voulons invoquer notre API comme le ferait par exemple un client JavaScript.
	private ObjectMapper objectMapper;

	JacksonTester<Movie> movieJacksonTester;
	
	@MockBean // Les mocks vont être créés par spring-boot-test qui apporte une encapsulation de Mockito
	MovieService movieService;
	
	@MockBean // Les mocks vont être créés par spring-boot-test qui apporte une encapsulation de Mockito
	CategoryService categoryService;

	@BeforeEach
	public void setUp() {
		JacksonTester.initFields(this, objectMapper);
	}


	@Test
	@DisplayName("Test : Tous les Movies sont retournés")
	@WithMockUser(username="pbouget", roles={"ADMIN", "CREATOR","READER"})
//	@WithAnonymousUser
	public void getAllMovies() throws Exception {
		
		when(this.movieService.findAllMovies()).thenReturn(new ArrayList<Movie>()); // on retourne la liste
		this.mockMvc.perform(get("/api/movie")).andExpect(status().isOk());
	}
	
	
	@Test
	@DisplayName("Test : Tous les Movies ne sont pas retournés")
	@WithMockUser(username="pbouget", roles={"ADMIN", "CREATOR","READER"})
	public void getMoviesNotFound() throws Exception {
		when(this.movieService.findAllMovies()).thenReturn(null); // on ne retourne rien
		this.mockMvc.perform(get("/api/movie")).andExpect(status().isNotFound());
	}
	
	@Test
	@DisplayName("Test : création d'un Movie")
	@WithMockUser(username="pbouget", roles={"ADMIN", "CREATOR","READER"})
	public void createMovie() throws Exception {
		Category category = categoryService.createNewCategory(new Category("Film culte"));
		Movie movie = new Movie("Dikkenek", 92, category);
		
		when(this.movieService.createNewMovie((Movie) (any()))).thenReturn(movie);

		this.mockMvc.perform(post("/api/movie")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(movie)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("name").value("Dikkenek"))
				.andExpect(jsonPath("duration").value("92"));
//				.andExpect(jsonPath("movie.category.name").value("Film culte"));
//				.andExpect(jsonPath("category.name").value("Film culte"));
		
	}
	
	@Test
	@DisplayName("Test : La création de Movie ne retourne null")
	@WithMockUser(username="pbouget", roles={"ADMIN", "CREATOR","READER"})
	public void createMovieReturnNull() throws Exception {
		when(this.movieService.createNewMovie((Movie) any())).thenReturn(null);
		this.mockMvc.perform(post("/api/movie")
				.content(""))
				.andReturn();
	}
	
	@Test
	@DisplayName("Test : Destruction d'un Movie introuvable")
	@WithMockUser(username="pbouget", roles={"ADMIN", "CREATOR","READER"})
	public void deleteMovieNotFound() throws Exception {
		
	//	doNothing().when(this.movieService).deleteMovie(9L);
	
		this.mockMvc.perform(delete("/api/movie/9"))
				.andExpect(status()
				.isNotFound());
	}
	
}

