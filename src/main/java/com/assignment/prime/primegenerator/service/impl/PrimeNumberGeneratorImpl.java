package com.assignment.prime.primegenerator.service.impl;
import org.springframework.stereotype.Service;

import com.assignment.prime.primegenerator.config.Algorithms;
import com.assignment.prime.primegenerator.model.PrimeNumberResponse;
import com.assignment.prime.primegenerator.service.PrimeNumberGenerator;
import com.assignment.prime.primegenerator.util.PrimeGeneratorUtility;


@Service
public class PrimeNumberGeneratorImpl implements PrimeNumberGenerator {

	@Override
	public PrimeNumberResponse generatePrime(int limit, Algorithms algorithm) {
		PrimeNumberResponse primeNumberResponse = new PrimeNumberResponse();
		switch (algorithm) {
		case ERATOSTHENES_SIEVE:
			primeNumberResponse = new PrimeNumberResponse(limit, PrimeGeneratorUtility.sieveOfEratosthenes(limit));
			break;
		case SQUARE_ROOT:
			primeNumberResponse = new PrimeNumberResponse(limit, PrimeGeneratorUtility.primeUsingSqrt(limit));
			break;
    	case ITERATIVE:
    		primeNumberResponse = new PrimeNumberResponse(limit, PrimeGeneratorUtility.primeNumbersNaiveApproach(limit));
            break;  
		default:
			primeNumberResponse = new PrimeNumberResponse(limit, PrimeGeneratorUtility.sieveOfEratosthenes(limit));
		}
		return primeNumberResponse;
	}

}
