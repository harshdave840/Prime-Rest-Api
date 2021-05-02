package com.assignment.prime.primegenerator.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.assignment.prime.primegenerator.config.Algorithms;
import com.assignment.prime.primegenerator.model.PrimeNumberResponse;
import com.assignment.prime.primegenerator.service.PrimeNumberGenerator;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PrimeNumberGeneratorImplTest {
	
	@Autowired
	PrimeNumberGenerator primeNumberGenerator;
	
    private static Stream<Arguments> providePrimeInput() {
        return Stream.of(
          Arguments.of(10,Algorithms.ERATOSTHENES_SIEVE,Arrays.asList(2,3,5,7)),
          Arguments.of(10,Algorithms.SQUARE_ROOT,Arrays.asList(2,3,5,7)),
          Arguments.of(10,Algorithms.ITERATIVE,Arrays.asList(2,3,5,7))
        );
    }
    
    @ParameterizedTest
    @MethodSource("providePrimeInput")
    void generatePrime(int initial, Algorithms algorithm, List<Integer> expectedList) {
    	PrimeNumberResponse response=primeNumberGenerator.generatePrime(initial,algorithm);
        assertEquals(expectedList, response.getPrimes());
    }

}
