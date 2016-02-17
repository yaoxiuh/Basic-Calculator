/**
 * 
 */
package edu.cmu.cs.cs214.hw2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.cmu.cs.cs214.hw2.expression.BinaryOperationExpression;
import edu.cmu.cs.cs214.hw2.expression.DerivativeExpression;
import edu.cmu.cs.cs214.hw2.expression.Expression;
import edu.cmu.cs.cs214.hw2.expression.NumberExpression;
import edu.cmu.cs.cs214.hw2.expression.UnaryOperationExpression;
import edu.cmu.cs.cs214.hw2.expression.VariableExpression;
import edu.cmu.cs.cs214.hw2.operator.Addition;
import edu.cmu.cs.cs214.hw2.operator.BinaryOperator;
import edu.cmu.cs.cs214.hw2.operator.Multiplication;
import edu.cmu.cs.cs214.hw2.operator.Negation;
import edu.cmu.cs.cs214.hw2.operator.Operator;
import edu.cmu.cs.cs214.hw2.operator.Subtraction;
import edu.cmu.cs.cs214.hw2.operator.UnaryOperator;
import edu.cmu.cs.cs214.hw2.parser.ExpressionMaker;

/**
 * 
 * @author Yaoxiu Hu
 * @version 1.0
 */
public class ExpressionTest {
	private final double tolerance = 10e-5;
    private ExpressionMaker expressionMaker = new ExpressionMaker();
    private final double num2 = 2;
    private final double num3 = 3;
    private final double num4 = 4;
    /**
     * Test binary operation expression
     */
	@Test
	public void testBinaryOperationExpression() {
		BinaryOperator addOperator = new Addition();
		Expression opperand1 = new NumberExpression(num2);
		Expression opperand2 = new NumberExpression(num4);
		Expression binaryOperation = expressionMaker.createBinaryOperationExpression(addOperator, opperand1, opperand2);
		System.out.println(binaryOperation.toString());//assertEquals("2.0 + 4.0", binaryOperation.toString());
		assertEquals(num2 + num4, binaryOperation.eval(), tolerance);
	}

	/**
	 * Test unary operation expression
	 */
	@Test
	public void testUnaryOperationExpression(){
		UnaryOperator negate = new Negation();
		Expression opperand1 = new NumberExpression(-num3);
		Expression unaryOperationExpression = expressionMaker.createUnaryOperationExpression(negate, opperand1);
		System.out.println(unaryOperationExpression.toString());
		assertEquals(num3, unaryOperationExpression.eval(),tolerance);
	}
	
	/**
	 * test derivative expression
	 */
	@Test
	public void testDerivativeExpression() {
		VariableExpression x = new VariableExpression("x");
		System.out.println(x.toString() + " " + x.name());
		x.store(num4);
		Expression fn = expressionMaker.createBinaryOperationExpression(new Multiplication(),x,x);
		Expression ftest = expressionMaker.createBinaryOperationExpression(new Subtraction(),fn,new NumberExpression(2));
		Expression test = new DerivativeExpression(ftest, x);
		assertEquals(test.eval(), num2 * x.eval(), tolerance);
	}
	
	/**
	 * test zero function 
	 */
	@Test
	public void testZero(){
		VariableExpression x = new VariableExpression("x");
		final double t1 = 10e-9;
		x.store(num4);
		BinaryOperator multiply = new Multiplication();
		Expression f1 = expressionMaker.createBinaryOperationExpression(multiply,x,x);
		Expression f2 = expressionMaker.createBinaryOperationExpression(multiply, expressionMaker.createNumberExpression(num3), x);
		Expression f3 = expressionMaker.createBinaryOperationExpression(new Subtraction(), f1, f2);
		Expression ftest = expressionMaker.createBinaryOperationExpression(new Addition(), f3, new NumberExpression(2));
		assertEquals(1, DerivativeExpression.zero(ftest, x, 0, t1), tolerance);
		assertEquals(2, DerivativeExpression.zero(ftest, x,num4, t1), tolerance);
		
	}
}
