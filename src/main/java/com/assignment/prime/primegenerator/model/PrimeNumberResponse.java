package com.assignment.prime.primegenerator.model;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class PrimeNumberResponse {
	private Long initial;

    @JacksonXmlElementWrapper(localName = "primes")
    @JacksonXmlProperty(localName = "prime")
    private List<Integer> primes;

    public PrimeNumberResponse(long initial, List<Integer> primes) {
        this.initial = initial;
        this.primes = primes;
    }

    public PrimeNumberResponse() {
    }    

    public Long getInitial() {
		return initial;
	}

	public void setInitial(Long initial) {
		this.initial = initial;
	}

	public List<Integer> getPrimes() {
        return primes;
    }

}
