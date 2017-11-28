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

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyCalculatorTest
{

	Calculator myCalculator;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		myCalculator = new MyCalculator();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		myCalculator = null;
	}

	@Test
	public void testSumNumbersHigher() throws NegativeNumberException
	{
		String s = "1001";
		int result = myCalculator.add(s);
		Assert.assertEquals(0, result);
	}


	@Test
	public void testSumTwoNumbersSuccess() throws NegativeNumberException
	{
		String s = "1, 2";
		int result = myCalculator.add(s);
		Assert.assertEquals(3, result);
	}

	@Test
	public void testSumOneNumberSuccess() throws NegativeNumberException
	{
		String s = "1";
		int result = myCalculator.add(s);
		Assert.assertEquals(1, result);

	}

	@Test
	public void testSumNoNumberSuccess() throws NegativeNumberException
	{
		String s = "";
		int result = myCalculator.add(s);
		Assert.assertEquals(0, result);

		result = myCalculator.add(null);
		Assert.assertEquals(0, result);
	}


	@Test
	public void testAnyNumberSuccess() throws NegativeNumberException
	{
		String s = "1,2,3,4,5,6,7,8,9,0";
		int result = myCalculator.add(s);
		Assert.assertEquals(45, result);
	}

	@Test
	public void testNegativeNumberShouldFailException() throws NegativeNumberException
	{
		String s = "-1,2";
		try
		{
			System.out.println( myCalculator.add(s) );
		}
		catch (NegativeNumberException e)
		{
			String msg = e.getMessage();

			Assert.assertEquals("negatives not allowed: -1", msg);
		}
	}

	@Test
	public void testNegativeNumber2ShouldFailException() throws NegativeNumberException
	{
		String s = "3,-1";
		try
		{
			myCalculator.add(s);
		}
		catch (NegativeNumberException e)
		{
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -1", msg);
		}
	}

	@Test
	public void testNegativeNumber3ShouldFailException() throws NegativeNumberException
	{
		String s = " -3,-1";
		try
		{
			myCalculator.add(s);
		}
		catch (NegativeNumberException e)
		{
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -3 -1", msg);
		}
	}

	@Test
	public void testNegativeNumber4ShouldFailException() throws NegativeNumberException
	{
		String s = "-2, -1";
		try
		{
			myCalculator.add(s);
		}
		catch (NegativeNumberException e)
		{
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -2 -1", msg);
		}
	}


	//SUB TESTE

	@Test
	public void testSumNumbersHigher2() throws NegativeNumberException
	{
		String s = "1001";
		int result = myCalculator.sub(s);
		Assert.assertEquals(0, result);
	}


	@Test
	public void testSubTwoNumbersSuccess() throws NegativeNumberException
	{
		String s = "1,2";
		int result = myCalculator.sub(s);
		Assert.assertEquals(-1, result);
	}

	@Test
	public void testSubOneNumberSuccess() throws NegativeNumberException
	{
		String s = "1";
		int result = myCalculator.sub(s);
		Assert.assertEquals(1, result);

	}

	@Test
	public void testSubNoNumberSuccess() throws NegativeNumberException
	{
		String s = "";
		int result = myCalculator.sub(s);
		Assert.assertEquals(0, result);

		result = myCalculator.sub(null);
		Assert.assertEquals(0, result);
	}


	@Test
	public void testAnyNumberSuccess2() throws NegativeNumberException
	{
		String s = "1,2,3";
		int result = myCalculator.sub(s);
		Assert.assertEquals(-4, result);
	}

	@Test
	public void testNegativeNumberShouldFailException2() throws NegativeNumberException
	{
		String s = "-1,2";
		try
		{
			System.out.println( myCalculator.sub(s) );
		}
		catch (NegativeNumberException e)
		{
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -1 ", msg);
		}
	}

	@Test
	public void testNegativeNumber2ShouldFailException2() throws NegativeNumberException
	{
		String s = "3,-1";
		try
		{
			myCalculator.sub(s);
		}
		catch (NegativeNumberException e)
		{
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -1 ", msg);
		}
	}

	@Test
	public void testNegativeNumber3ShouldFailException3() throws NegativeNumberException
	{
		String s = " -3,-1";
		try
		{
			myCalculator.sub(s);
		}
		catch (NegativeNumberException e)
		{
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -3 -1 ", msg);
		}
	}

	@Test
	public void testNegativeNumber4ShouldFailException4() throws NegativeNumberException
	{
		String s = "-2, -1";
		try
		{
			myCalculator.sub(s);
		}
		catch (NegativeNumberException e)
		{
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -2 -1 ", msg);
		}
	}


	//MULT TESTE

	@Test
	public void testSumNumbersHigher3() throws NegativeNumberException
	{
		String s = "1001";
		double result = myCalculator.mult(s);
		Assert.assertEquals(0, result, 0.1);
	}


	@Test
	public void testMultTwoNumbersSuccess() throws NegativeNumberException
	{
		String s = "1,2";
		double result = myCalculator.mult(s);
		Assert.assertEquals(2, result, 0.1);
	}

	@Test
	public void testMultOneNumberSuccess() throws NegativeNumberException
	{
		String s = "1";
		double result = myCalculator.mult(s);
		Assert.assertEquals(1, result, 0.1);

	}

	@Test
	public void testMultNoNumberSuccess() throws NegativeNumberException
	{
		String s = "";
		double result = myCalculator.mult(s);
		Assert.assertEquals(0, result, 0.1);

		result = myCalculator.mult(null);
		Assert.assertEquals(0, result, 0.1);
	}


	@Test
	public void testAnyNumberSuccess3() throws NegativeNumberException
	{
		String s = "1,2,3";
		double result = myCalculator.mult(s);
		Assert.assertEquals(6, result, 0.1);
	}

	@Test
	public void testNegativeNumberShouldFailException3() throws NegativeNumberException
	{
		String s = "-1,2";
		try
		{
			System.out.println( myCalculator.mult(s) );
		}
		catch (NegativeNumberException e)
		{
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -1 ", msg);
			System.out.println("faiou");
		}
	}

	@Test
	public void testNegativeNumber2ShouldFailException3() throws NegativeNumberException
	{
		String s = "3,-1";
		try
		{
			myCalculator.mult(s);
		}
		catch (NegativeNumberException e)
		{
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -1 ", msg);
		}
	}

	@Test
	public void testNegativeNumber3ShouldFailException4() throws NegativeNumberException
	{
		String s = " -3,-1";
		try
		{
			myCalculator.mult(s);
		}
		catch (NegativeNumberException e)
		{
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -3 -1 ", msg);
		}
	}

	@Test
	public void testNegativeNumber4ShouldFailException5() throws NegativeNumberException
	{
		String s = "-2, -1";
		try
		{
			myCalculator.mult(s);
		}
		catch (NegativeNumberException e)
		{
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -2 -1 ", msg);
		}
	}


	//DIV TESTE


	@Test
	public void testSumNumbersHigher4() throws NegativeNumberException
	{
		String s = "1001";
		double result = myCalculator.div(s);
		Assert.assertEquals(0, result, 0.1);
	}


	@Test
	public void testMultTwoNumbersSuccess4() throws NegativeNumberException
	{
		String s = "1,2";
		double result = myCalculator.div(s);
		Assert.assertEquals(2, result, 0.1);
	}

	@Test
	public void testMultOneNumberSuccess4() throws NegativeNumberException
	{
		String s = "1";
		double result = myCalculator.div(s);
		Assert.assertEquals(1, result, 0.1);

	}

	@Test
	public void testMultNoNumberSuccess4() throws NegativeNumberException
	{
		String s = "";
		double result = myCalculator.div(s);
		Assert.assertEquals(0, result, 0.1);

		result = myCalculator.div(null);
		Assert.assertEquals(0, result, 0.1);
	}


	@Test
	public void testAnyNumberSuccess4() throws NegativeNumberException
	{
		String s = "1,2,3";
		double result = myCalculator.div(s);
		Assert.assertEquals(6, result, 0.1);
	}

	@Test
	public void testNegativeNumberShouldFailException4() throws NegativeNumberException
	{
		String s = "-1,2";
		try
		{
			System.out.println( myCalculator.mult(s) );
		}
		catch (NegativeNumberException e)
		{
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -1 ", msg);
		}
	}

	@Test
	public void testNegativeNumber2ShouldFailException4() throws NegativeNumberException
	{
		String s = "3,-1";
		try
		{
			myCalculator.div(s);
		}
		catch (NegativeNumberException e)
		{
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -1 ", msg);
		}
	}

	@Test
	public void testNegativeNumber3ShouldFailException5() throws NegativeNumberException
	{
		String s = " -3,-1";
		try
		{
			myCalculator.div(s);
		}
		catch (NegativeNumberException e)
		{
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -3 -1 ", msg);
		}
	}

	@Test
	public void testNegativeNumber4ShouldFailException6() throws NegativeNumberException
	{
		String s = "-2, -1";
		try
		{
			myCalculator.div(s);
		}
		catch (NegativeNumberException e)
		{
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -2 -1 ", msg);
		}
	}


	@Test
	public void testZeroDivision()
	{
		String s = "1, 0";

		try
		{
			myCalculator.div(s);
		}
		catch (NegativeNumberException e)
		{
			String msg = e.getMessage();
			Assert.assertEquals("Zero division not allowed.", msg);
		}
	}

}
