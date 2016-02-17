/**
 * 
 */
package edu.cmu.cs.cs214.hw2.expression;

import edu.cmu.cs.cs214.hw2.operator.UnaryOperator;

/**
 * @description
 * @author Yaoxiu Hu
 * @version 1.0
 */
public class UnaryOperationExpression implements Expression{

	private UnaryOperator unaryOperator;
	private Expression opperand;
	
	/**
	 * @param operator
	 * 		unary operator
	 * @param opperand2
	 * 		opperand
	 */
	public UnaryOperationExpression(UnaryOperator operator, Expression opperand2) {
		// TODO Auto-generated constructor stub
		this.opperand = opperand2;
		this.unaryOperator = operator;
	}

	/* (non-Javadoc)
	 * @see edu.cmu.cs.cs214.hw2.expression.Expression#eval()
	 */
	@Override
	public double eval() {
		// TODO Auto-generated method stub
		//return 0;
		return unaryOperator.apply(opperand.eval());
	}
	
	@Override
	public String toString(){
		return unaryOperator.toString() + " " + opperand.toString();
	}

}
