package za.co.iqbusiness.online.application;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import za.co.iqbusiness.online.application.controller.PersonController;
import za.co.iqbusiness.online.application.service.PersonService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PersonController.class)
class OnlineApplicationServiceApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PersonService personService;

	@Test
	void contextLoads() {
	}

}
