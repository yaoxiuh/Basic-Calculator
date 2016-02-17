/**
 * 
 */
package edu.cmu.cs.cs214.hw2.expression;

/**
 * @description
 * @author Yaoxiu Hu
 * @version 1.0
 */
public class NumberExpression implements Expression{

	private double value;
	
	/**
	 * constructor
	 * @param value
	 *  	value of the number expression
	 */
	public NumberExpression(double value){
		this.value = value;
	}
	/* (non-Javadoc)
	 * @see edu.cmu.cs.cs214.hw2.expression.Expression#eval()
	 */
	@Override
	public double eval() {
		// TODO Auto-generated method stub
		return this.value;
	}
	
	@Override
	public String toString(){
		return Double.toString(value);
	}

}
