package com.assignment.prime.primegenerator.service;

import com.assignment.prime.primegenerator.config.Algorithms;
import com.assignment.prime.primegenerator.model.PrimeNumberResponse;

public interface PrimeNumberGenerator {
	
	public PrimeNumberResponse generatePrime(int limit,Algorithms algorithm);

}
