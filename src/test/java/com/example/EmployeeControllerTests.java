package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTests {

	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders
				.standaloneSetup(new EmployeeController())
				.build();
	}
	
	@Test
	public void getEmployee() throws Exception {
		String expectedResult ="[{\"name\":\"John\",\"gender\":\"Male\", \"id\": 1},{\"name\":\"Johnny\",\"gender\":\"Male\", \"id\": 2},{\"name\":\"Travolta\",\"gender\":\"Male\", \"id\": 4},{\"name\":\"Mickey\",\"gender\":\"Male\", \"id\": 6},{\"name\":\"Donald\",\"gender\":\"Male\", \"id\": 8}]";
	    this.mockMvc.perform(get("/employees?gender=Male"))
	        .andExpect(status().isOk())
	        .andExpect(content().json(expectedResult));
	}
	
	@Test
	public void getEmployeePost() throws Exception {
	    this.mockMvc.perform(post("/employees").contentType("application/json").content("{\"name\":\"lala\",\"gender\":\"Male\"}"))
	        .andExpect(status().isOk())
	        .andExpect(content().json("{\"name\":\"lala\",\"gender\":\"Male\", \"id\": 0}"));
	}
	
	@Test
	public void shouldReturnNotFound() throws Exception {
		String expectedResult ="{\"name\":\"John\",\"gender\":\"Male\",\"id\":1}";
	    this.mockMvc.perform(get("/employees/10"))
	        .andExpect(status().isNotFound());
	    this.mockMvc.perform(get("/employees/1"))
	        .andExpect(status().isOk())
	        .andExpect(content().json(expectedResult));
	}

}
