/**
 * 
 */
package edu.cmu.cs.cs214.hw2;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.cmu.cs.cs214.hw2.operator.Absolute;
import edu.cmu.cs.cs214.hw2.operator.Addition;
import edu.cmu.cs.cs214.hw2.operator.Division;
import edu.cmu.cs.cs214.hw2.operator.Exponentiation;
import edu.cmu.cs.cs214.hw2.operator.Module;
import edu.cmu.cs.cs214.hw2.operator.Multiplication;
import edu.cmu.cs.cs214.hw2.operator.Negation;
import edu.cmu.cs.cs214.hw2.operator.Subtraction;

/**
 * 
 * @author Yaoxiu Hu
 * @version 1.0
 */
public class OperatorsTest {

	private final double tolerance = 10e-9;
	private final double t1 = 4;
	private final double t2 = 2;
	/**
	 * Test addition operator
	 */
	@Test
	public void testAdditionOperator(){
		Addition addition = new Addition();
		assertEquals(t1+t2, addition.apply(t1, t2),tolerance);
		assertEquals("+",addition.toString() );
	}
	
	/**
	 * Test division operator
	 */
	@Test
	public void testDivisionOperator(){
		Division division = new Division();
		assertEquals(t1 / t2, new Division().apply(t1, t2),tolerance);
		assertEquals("/",division.toString() );
	}
	
	/**
	 * test multiplication operator
	 */
	@Test
	public void testMultiplicationOperator(){
		Multiplication multiplication = new Multiplication();
		assertEquals(t1 * t2, multiplication.apply(t1, t2),tolerance);
		assertEquals("*",multiplication.toString() );
	}
	
	/**
	 * Test subtraction operator
	 */
	@Test
	public void testSubtractionOperator(){
		Subtraction subtraction = new Subtraction();
		assertEquals(t1 - t2, subtraction.apply(t1, t2),tolerance);
		assertEquals("-",subtraction.toString() );
	}
	
	/**
	 * Test absolute operator
	 */
	@Test
	public void testAbsoluteOperator(){
		Absolute absolute = new Absolute();
		assertEquals(t1, absolute.apply(-t1),tolerance);
		assertEquals(t1, absolute.apply(t1),tolerance);
		assertEquals("Abs",absolute.toString() );
	}
	
	/**
	 * Test negation operator
	 */
	@Test
	public void testNegationOperator(){
		Negation negation = new Negation();
		assertEquals(-t1, negation.apply(t1),tolerance);
		assertEquals(t1, negation.apply(-t1),tolerance);
		assertEquals(0, negation.apply(0),tolerance);
		assertEquals("Neg",negation.toString() );
	}
	
	/**
	 * Test module operator
	 */
	@Test
	public void testModuleOperator(){
		Module module = new Module();
		assertEquals(t1 % t2, module.apply(t1,t2),tolerance);
		assertEquals("%",module.toString() );
	}
	
	/**
	 * test exponention operator
	 */
	@Test
	public void testExponentionOperator(){
		Exponentiation exponentiation = new Exponentiation();
		assertEquals(Math.pow(t1, t2), exponentiation.apply(t1, t2),tolerance);
		assertEquals("^",exponentiation.toString() );
	}

}
