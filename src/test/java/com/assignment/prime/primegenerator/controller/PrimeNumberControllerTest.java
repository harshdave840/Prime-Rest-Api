package com.assignment.prime.primegenerator.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.http.MediaType;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PrimeNumberControllerTest {
	
	
	@Autowired
    private MockMvc mockMvc;

	@Test
    public void test() throws Exception {
        mockMvc.perform(get("/primes/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("initial", is(10)))
                .andExpect(jsonPath("primes").isArray())
                .andExpect(jsonPath("primes", hasItems(2, 3, 5, 7)));

    }
	
	@Test
    public void testXml() throws Exception {
		String prime = "/ns:prime[%s]";
        mockMvc.perform(get("/primes/10").accept(MediaType.APPLICATION_XML))
                .andExpect(status().isOk())
                .andExpect(xpath("//initial").string("10"))
                .andExpect(xpath("//prime",1).string("2"));
	}
}
