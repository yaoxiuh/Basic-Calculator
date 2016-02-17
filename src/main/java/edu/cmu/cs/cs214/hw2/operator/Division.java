/**
 * 
 */
package edu.cmu.cs.cs214.hw2.operator;

/**
 * Division operator
 * @author Yaoxiu Hu
 * @version 1.0
 */
public class Division implements BinaryOperator{

	/* (non-Javadoc)
	 * @see edu.cmu.cs.cs214.hw2.operator.BinaryOperator#apply(double, double)
	 */
	@Override
	public double apply(double arg1, double arg2) {
		// TODO Auto-generated method stub
		return arg1 / arg2;
	}
	
	@Override
	public String toString(){
		return "/";
	}

}
