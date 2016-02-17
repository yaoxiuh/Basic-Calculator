/**
 * 
 */
package edu.cmu.cs.cs214.hw2.expression;

/**
 * 
 * @author Yaoxiu Hu
 * @version 1.0
 */
public class DerivativeExpression implements Expression {

	private Expression fn;
	private VariableExpression independentVar;
	private static final double DELTA_X = 1e-9;

	/**
	 * Creates an expression representing the derivative of the specified
	 * function with respect to the specified variable.
	 *
	 * @param fn
	 *            the function whose derivative this expression represents
	 * @param independentVar
	 *            the variable with respect to which we're differentiating
	 */
	public DerivativeExpression(Expression fn, VariableExpression independentVar) {
		this.fn = fn;
		this.independentVar = independentVar;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.cmu.cs.cs214.hw2.expression.Expression#eval()
	 */
	@Override
	public double eval() {
		double value = independentVar.eval();
		independentVar.store(DELTA_X + value);
		// TODO Auto-generated method stub
		double fd = fn.eval();
		independentVar.store(value);
		return (fd - fn.eval()) / DELTA_X;
	}

	/**
	 * Returns a zero of the specified function using Newton's method with
	 * approxZero as the initial estimate.
	 *
	 * @param fn
	 *            the function whose zero is to be found
	 * @param x
	 *            the independent variable of the function
	 * @param approxZero
	 *            initial approximation for the zero of the function
	 * @param tolerance
	 *            how close zero the returned zero has to be
	 * @return a value x for which f(x) is "close to zero" (<= tolerance)
	 */
	public static double zero(Expression fn, VariableExpression x, double approxZero, double tolerance) {
		x.store(approxZero);
		while(Math.abs(fn.eval()) > tolerance){
			DerivativeExpression derivation = new DerivativeExpression(fn,x);
			approxZero = approxZero - fn.eval()/derivation.eval();
			x.store(approxZero);
		}
		return approxZero;
	}
}
