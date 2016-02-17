package edu.cmu.cs.cs214.hw2.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

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
 * Main - creates and runs a new Calculator GUI. 
 *
 */
public class Main {

	/**
	 * Runs the calculator GUI.
	 * 
	 * @param args arguments to the main function 
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> createAndShowSetupScreen());
	}
	
	private static void createAndShowSetupScreen() {
		List<Operator> operators = new ArrayList<>();
		
		operators.add(new Addition());
		operators.add(new Subtraction());
		operators.add(new Multiplication());
		operators.add(new Division());
		operators.add(new Absolute());
		operators.add(new Negation());
		operators.add(new Exponentiation());
		operators.add(new Module());
		Calculator calculator = new Calculator(operators);
		calculator.launch();
	}

}
