package assignment3;

import java.util.Scanner;

public class PFixCLI {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String expression = null; // expression to be evaluated
		final String STOP = "X"; // indicates end of input
		int result; // result of evaluation

		while (!STOP.equals(expression)) {
			// Get next expression to be processed.
			System.out.print("\nPostfix Expression (" + STOP + " to stop): ");
			expression = scan.nextLine();

			if (!STOP.equals(expression)) {
				// Obtain and output result of expression evaluation.
				try {
					result = PostFixEvaluator.evaluate(expression);

					// Output result.
					System.out.println("Result = " + result);
				} catch (PostFixException error) {
					// Output error message.
					System.out.println("Error in expression - " + error.getMessage());
				}
			}
		}
	}
}