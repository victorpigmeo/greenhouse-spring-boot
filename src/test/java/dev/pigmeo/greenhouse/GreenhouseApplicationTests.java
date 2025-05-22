package dev.pigmeo.greenhouse;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.pigmeo.greenhouse.controllers.HomeControllerTest;

@SpringBootTest
class GreenhouseApplicationTests {

	@Autowired
	private HomeControllerTest homeController;

	@Test
	void contextLoads() {
		assertThat(homeController).isNotNull();
	}

}
