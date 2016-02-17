/**
 * 
 */
package edu.cmu.cs.cs214.hw2.expression;

import edu.cmu.cs.cs214.hw2.operator.BinaryOperator;

/**
 * @author Yaoxiu Hu
 * @version 1.0
 */
public class BinaryOperationExpression implements Expression {
	private BinaryOperator binaryOperator;
	private Expression opperand1;
	private Expression opperand2;

	/**
	 * construct a binary operation expression
	 * 
	 * @param operator
	 *            the binary operator
	 * @param opperand1
	 *            opperand1
	 * @param opperand2
	 *            opperand2
	 */
	public BinaryOperationExpression(BinaryOperator operator, Expression opperand1, Expression opperand2) {
		this.binaryOperator = operator;
		this.opperand1 = opperand1;
		this.opperand2 = opperand2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.cmu.cs.cs214.hw2.expression.Expression#eval()
	 */
	@Override
	public double eval() {
		return binaryOperator.apply(opperand1.eval(), opperand2.eval());
	}

	@Override
	public String toString() {
		return opperand1.toString() + " " + binaryOperator.toString() + " " + opperand2.toString();
	}

}
