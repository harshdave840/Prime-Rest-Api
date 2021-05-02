package com.assignment.prime.primegenerator.controller;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.prime.primegenerator.config.Algorithms;
import com.assignment.prime.primegenerator.model.PrimeNumberResponse;
import com.assignment.prime.primegenerator.service.PrimeNumberGenerator;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/")
public class PrimeNumberController {
	
	@Autowired
	PrimeNumberGenerator primeNumberGenerator;
	
	
	/**
     * API Operation that generates a list of prime numbers from 2 to the upperBound (inclusive)
     *
     * @param upperBound The inclusive upper bound to limit the size of the returned primes
     * @return a list of prime numbers from 2 to the upperBound (inclusive)
     */
	
    @RequestMapping(value = "/primes/{initial}", produces = {"application/json", "application/xml"},method = RequestMethod.GET)
    @ResponseBody
    public PrimeNumberResponse list(@ApiParam(value = "the upper limit of primes to be generated.") @PathVariable String initial,@ApiParam(value = "algorithm to use.") @RequestParam(value = "algorithm", required = false, defaultValue ="ERATOSTHENES_SIEVE") Algorithms algorithm) {   	
        int initialValue=Integer.parseInt(initial);
    	return primeNumberGenerator.generatePrime(initialValue,algorithm);
    }

    @ModelAttribute
    public void setCacheControlHeader(HttpServletResponse response) {
        String headerValue = CacheControl.maxAge(600, TimeUnit.SECONDS).getHeaderValue();
        response.addHeader(HttpHeaders.CACHE_CONTROL, headerValue);
    }

}
