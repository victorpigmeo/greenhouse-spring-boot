package dev.pigmeo.greenhouse;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.pigmeo.greenhouse.controllers.EspController;

@SpringBootTest
class GreenhouseApplicationTests {

	@Autowired
	private EspController espController;

	@Test
	void contextLoads() {
		assertThat(espController).isNotNull();
	}

}
