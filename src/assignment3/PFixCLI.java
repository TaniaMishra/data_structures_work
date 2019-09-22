package assignment3;

import java.util.Scanner;

public class PFixCLI {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String expression = null; // expression to be evaluated
		final String STOP = "X"; // indicates end of input
		int result; // result of evaluation
		int count;
		int average;
		int largest;
		int smallest;
		int[] stats; //stats from the evaluation

		while (!STOP.equals(expression)) {
			// Get next expression to be processed.
			System.out.print("\nPostfix Expression (" + STOP + " to stop): ");
			expression = scan.nextLine();

			if (!STOP.equals(expression)) {
				// Obtain and output result of expression evaluation.
				try {
					stats = PostFixEvaluator.evaluate(expression);
					result = stats[0];
					// Output result.
					System.out.println("Result = " + result);

				} catch (PostFixException error) {
					// Output error message.
					System.out.println("Error in expression - " + error.getMessage());
				}
			}
			
			//Output statistics
			stats = PostFixEvaluator.evaluate(expression);
			largest = stats[1];
			smallest = stats[2];
			count = stats[3];
			average = stats[4];
			System.out.println("**STATISTICS**");
			System.out.println("Largest Number: " + largest);
			System.out.println("Smallest Number: " + smallest);
			System.out.println("Count: " + count);
			System.out.println("Average: " + average);
		}
	}
}