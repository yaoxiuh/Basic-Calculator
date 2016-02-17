/**
 * 
 */
package edu.cmu.cs.cs214.hw2.parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import edu.cmu.cs.cs214.hw2.expression.Expression;
import edu.cmu.cs.cs214.hw2.operator.Absolute;
import edu.cmu.cs.cs214.hw2.operator.Addition;
import edu.cmu.cs.cs214.hw2.operator.Division;
import edu.cmu.cs.cs214.hw2.operator.Exponentiation;
import edu.cmu.cs.cs214.hw2.operator.Module;
import edu.cmu.cs.cs214.hw2.operator.Multiplication;
import edu.cmu.cs.cs214.hw2.operator.Negation;
import edu.cmu.cs.cs214.hw2.operator.Operator;
import edu.cmu.cs.cs214.hw2.operator.Subtraction;

/**
 * CommandLineParser - a command line calculator.
 * 
 * You will need to add any new Operators you create to the 
 * operatorSet or they will not be usable in the command line 
 * calculator.
 *
 */
public class CommandLineParser {
	
	/**
	 * @param args program arguments
	 */
	public static void main(String[] args) {
		
		Set<Operator> operatorSet = new HashSet<Operator>();
		operatorSet.add(new Addition());
		operatorSet.add(new Subtraction());
		operatorSet.add(new Multiplication());
		operatorSet.add(new Division());
		operatorSet.add(new Absolute());
		operatorSet.add(new Negation());
		operatorSet.add(new Exponentiation());
		operatorSet.add(new Module());
		
		ExpressionParser parser = new ExpressionParser(operatorSet, new ExpressionMaker());
		
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Enter an expression");
			String expression = scanner.nextLine();
			try {
				Expression exp = parser.parse(expression);
				System.out.println("Result: " + exp.eval());
			} catch (Exception e) {
				System.out.println("Input format not accepted. Please try again." );
			}
		} while(true);

		
	}

}
