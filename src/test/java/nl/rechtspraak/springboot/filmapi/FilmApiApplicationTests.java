package nl.rechtspraak.springboot.filmapi;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles({"unit-test"})
public class FilmApiApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getFilmList() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/films"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()", Matchers.is(2)));
	}

	@Test
	public void getFilmDetail() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/films/123"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.titel", Matchers.equalTo("The Ususal Suspects 2")));
	}

	@Test
	public void getFilmDetailBestaatNiet() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/films/1234567890"))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	public void updateFilmNieuw() throws Exception {

		ResultMatcher notFound = MockMvcResultMatchers.status()
				.isNotFound();

		MockHttpServletRequestBuilder builder =
				MockMvcRequestBuilders.put("/films/789")
						.contentType("application/json")
						.accept("application/json")
						.content(getFilmInJSON());
		this.mockMvc.perform(builder)
				.andExpect(notFound);
	}

	private String getFilmInJSON(){
		return "{\"titel\":\"Once Upon a Time in the West\",\n" +
				"\"releaseJaar\":1968,\n" +
				"\"acteurs\":[\"Henry Fonda\", \"Charles Bronson\", \"Claudia Cardinale\"],\n" +
				"\"duur\":\"PT2H45M\",\n" +
				"\"regisseur\":\"Sergio Leone\",\n" +
				"\"id\":\"789\"}";
	}

	private String getFilmInJSON2(){
		return "{\"titel\":\"The Ususal Suspects 2\",\"releaseJaar\":1995,\"acteurs\":[\"Chazz Palminteri\",\"Kevin Spacey\",\"Gabriel Byrne\"],\"duur\":\"PT1H46M\",\"regisseur\":\"Bryan Singer\",\"id\":\"123\"}";
	}

	@Test
	public void updateFilmBestaand() throws Exception {

		ResultMatcher accepted = MockMvcResultMatchers.status()
				.isAccepted();

		MockHttpServletRequestBuilder builder =
				MockMvcRequestBuilders.put("/films/123")
						.contentType("application/json")
						.accept("application/json")
						.content(getFilmInJSON2());
		this.mockMvc.perform(builder)
				.andExpect(accepted)
				.andExpect(MockMvcResultMatchers.jsonPath("$.titel", Matchers.equalTo("The Ususal Suspects 2")));

	}

	@Test
	public void deleteFilm() throws Exception {
		ResultMatcher accepted = MockMvcResultMatchers.status()
				.isAccepted();
		MockHttpServletRequestBuilder builder =
				MockMvcRequestBuilders.delete("/films/123");
		this.mockMvc.perform(builder)
				.andExpect(accepted);
	}

	@Test
	public void deleteFilmBestaatNiet() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.delete("/films/1234567890"))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	public void createFilm() throws Exception {
		ResultMatcher accepted = MockMvcResultMatchers.status()
				.isAccepted();

		MockHttpServletRequestBuilder builder =
				MockMvcRequestBuilders.post("/films/789")
						.contentType("application/json")
						.accept("application/json")
						.content(getFilmInJSON());
		this.mockMvc.perform(builder)
				.andExpect(accepted);
	}

	@Test
	public void createFilmBestaatAl() throws Exception {
		ResultMatcher conflict = MockMvcResultMatchers.status()
				.isConflict();

		MockHttpServletRequestBuilder builder =
				MockMvcRequestBuilders.post("/films/456")
						.contentType("application/json")
						.accept("application/json")
						.content(getFilmInJSON());
		this.mockMvc.perform(builder)
				.andExpect(conflict);
	}

}
