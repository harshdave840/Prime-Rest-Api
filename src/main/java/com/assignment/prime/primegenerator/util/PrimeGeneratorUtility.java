package com.assignment.prime.primegenerator.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeGeneratorUtility {
	
	public static List<Integer> primeUsingSqrt(int limit) {
		return IntStream.rangeClosed(0, limit).parallel().filter(PrimeGeneratorUtility::isPrime).boxed().collect(Collectors.toList());
	}
			
	private static boolean isPrime(int num) {
        if (num <= 2) {
            return num == 2;
        }
        return (num % 2 != 0)
                &&
                IntStream.rangeClosed(2, (int) (Math.sqrt(num)))
                		.parallel()
                        .filter(x -> x % 2 != 0)
                        .noneMatch(n -> (num % n == 0));
    }	 	
	
	public static List<Integer> sieveOfEratosthenes(int limit) {
	    boolean prime[] = new boolean[limit + 1];
	    Arrays.fill(prime, true);
	    for (int p = 2; p * p <= limit; p++) {
	        if (prime[p]) {
	            for (int i = p * 2; i <= limit; i += p) {
	                prime[i] = false;
	            }
	        }
	    }
	    List<Integer> primeNumbers = new LinkedList<>();
	    for (int i = 2; i <= limit; i++) {
	        if (prime[i]) {
	            primeNumbers.add(i);
	        }
	    }
	    return primeNumbers;
	}
	
	public static List <Integer> primeNumbersNaiveApproach(int limit) {
        return IntStream
            .rangeClosed(2, limit)
            .filter(x -> isPrimeNaive(x)).boxed()
            .collect(Collectors.toList());
    }
	
	private static boolean isPrimeNaive(int number) {
        return number > 1 && IntStream
            .range(2, number)
            .noneMatch(i -> number % i == 0);
    }

}
