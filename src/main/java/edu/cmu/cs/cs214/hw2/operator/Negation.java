/**
 * 
 */
package edu.cmu.cs.cs214.hw2.operator;

/**
 * Negate Operator
 * @author Yaoxiu Hu
 * @version 1.0
 */
public class Negation implements UnaryOperator{

	/* (non-Javadoc)
	 * @see edu.cmu.cs.cs214.hw2.operator.UnaryOperator#apply(double)
	 */
	@Override
	public double apply(double arg) {
		// TODO Auto-generated method stub
		if(arg == 0)
			return arg;
		else
			return -arg;
	}
	
	@Override
	public String toString(){
		return "Neg";
	}

	
}
