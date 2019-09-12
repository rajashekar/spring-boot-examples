package com.udacity.bootstrap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BootstrapApplicationTests {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getAllDogsForbidden() {
		ResponseEntity<Object> response = this.restTemplate.getForEntity("http://localhost:" + port + "/dogs",
				Object.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.UNAUTHORIZED));
	}

	@Test
	public void getAllDogs() {
		ResponseEntity<Object> response = this.restTemplate.withBasicAuth("admin", "password")
				.getForEntity("http://localhost:" + port + "/dogs", Object.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}

}
