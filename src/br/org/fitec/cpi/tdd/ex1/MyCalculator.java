//**********************************************************************
// Copyright (c) 2017 Telefonaktiebolaget LM Ericsson, Sweden.
// All rights reserved.
// The Copyright to the computer program(s) herein is the property of
// Telefonaktiebolaget LM Ericsson, Sweden.
// The program(s) may be used and/or copied with the written permission
// from Telefonaktiebolaget LM Ericsson or in accordance with the terms
// and conditions stipulated in the agreement/contract under which the
// program(s) have been supplied.
// **********************************************************************
package br.org.fitec.cpi.tdd.ex1;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyCalculator implements Calculator
{

	@Override
	public int add(String s) throws NegativeNumberException
	{
		if (s == null || s.length() == 0) return 0;

		String builder = configSpace(s);

		if (builder.length() > 0)
		{
			throw new NegativeNumberException("negatives not allowed: " + builder.toString());
		}

		return Stream.of(s.split(","))
				.map(String::trim)
				.mapToInt(Integer::parseInt)
				.filter(n-> n<=1000)
				.sum();
	}

	@Override
	public int sub(String s) throws NegativeNumberException{

		if (s == null || s.length() == 0) return 0;

		String builder = configSpace(s);

		if (builder.length() > 0)
		{
			throw new NegativeNumberException("negatives not allowed: " + builder.toString());
		}
		return Stream.of(s.split(","))
				.map(String::trim)
				.mapToInt(Integer::parseInt)
				.filter(n->n<=1000)
				.reduce((a,b)-> a - b)
				.orElse(0);
	}

	@Override
	public double mult(String s) throws NegativeNumberException{

		if (s == null || s.length() == 0) return 0;

		String builder = configSpace(s);

		if (builder.length() > 0)
		{
			throw new NegativeNumberException("negatives not allowed: " + builder.toString());
		}
		return Math.round( Stream.of(s.split(","))
				.map(String::trim)
				.mapToInt(Integer::parseInt)
				.filter(n->n<=1000)
				.reduce((a,b)-> a * b)
				.orElse(0) *10)/10;
	}


	@Override
	public double div(String s) throws NegativeNumberException{

		if (s == null || s.length() == 0) return 0;



		String builder = configSpace(s);

		if (builder.length() > 0)
		{
			throw new NegativeNumberException("negatives not allowed: " + builder.toString());
		}

		Double resultado =  Stream.of(s.split(","))
				.map(String::trim)
				.mapToDouble(Double::parseDouble)
				.filter(n->n<=1000)
				.reduce((a,b)-> a / b)
				.orElse(0);

		if(Double.isFinite(resultado))
			return resultado;
		else
			throw new NegativeNumberException("Zero division not allowed.");
	}


	private String configSpace(String s){
		return Stream.of(s.split(","))
				.map(String::trim)
				.filter(n->Integer.parseInt(n)<0)
				.collect(Collectors.joining(" "));
	}
}
