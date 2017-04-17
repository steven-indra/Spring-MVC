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
		String expectedResult ="[{\"name\":\"John\",\"gender\":\"Male\"},{\"name\":\"Johnny\",\"gender\":\"Male\"},{\"name\":\"Travolta\",\"gender\":\"Male\"},{\"name\":\"Mickey\",\"gender\":\"Male\"},{\"name\":\"Donald\",\"gender\":\"Male\"}]";
	    this.mockMvc.perform(get("/employee?gender=Male"))
	        .andExpect(status().isOk())
	        .andExpect(content().json(expectedResult));
	}
	
	@Test
	public void getEmployeePost() throws Exception {
	    this.mockMvc.perform(post("/employee").contentType("application/json").content("{\"name\":\"lala\",\"gender\":\"Male\"}"))
	        .andExpect(status().isOk())
	        .andExpect(content().json("{\"name\":\"lala\",\"gender\":\"Male\"}"));
	}

}
