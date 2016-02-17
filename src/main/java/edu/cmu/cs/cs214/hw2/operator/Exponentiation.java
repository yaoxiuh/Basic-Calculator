/**
 * 
 */
package edu.cmu.cs.cs214.hw2.operator;

/**
 * Exponentiation operator
 * @author Yaoxiu Hu
 * @version 1.0
 */
public class Exponentiation implements BinaryOperator{

	/* (non-Javadoc)
	 * @see edu.cmu.cs.cs214.hw2.operator.BinaryOperator#apply(double, double)
	 */
	@Override
	public double apply(double arg1, double arg2) {
		// TODO Auto-generated method stub
		return Math.pow(arg1,arg2);
	}
	
	@Override
	public String toString(){
		return "^";
	}

}
