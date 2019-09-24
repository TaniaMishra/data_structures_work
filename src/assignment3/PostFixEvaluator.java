package assignment3;

import java.util.Scanner;

public class PostFixEvaluator {
	public int count;
	public double average;
	public int largest;
	public int smallest;
	
	public PostFixEvaluator() {
		count = 0;
		average = 0.0;
		largest = 0;
		smallest = 0;
	}
	public int evaluate(String expression) {
		Scanner tokenizer = new Scanner(expression);
		StackInterface<Integer> stack = new ArrayBoundedStack<Integer>(50);

		int value;
		String operator;
		int operand1, operand2;
		int result = 0;
		
		while (tokenizer.hasNext()) {
			if (tokenizer.hasNextInt()) {
				// Process operand.
				value = tokenizer.nextInt();
				if (stack.isFull())
					throw new PostFixException("Too many operands-stack overflow");
				stack.push(value);
				count++;
				average += value;
				if (count == 1) {
					largest = value;
					smallest = value;
				}
				else if (value > largest) {
					largest = value;
				}
				else if (value < smallest) {
					smallest = value;
				}
				
			} else {
				// Process operator.
				operator = tokenizer.next();

				// Check for illegal symbol
				if (!(operator.equals("/") || operator.equals("*") || operator.equals("+") || operator.equals("-") || operator.equals("^")))
					throw new PostFixException("Illegal symbol: " + operator);

				// Obtain second operand from stack.
				if (stack.isEmpty())
					throw new PostFixException("Not enough operands-stack underflow");
				operand2 = stack.top();
				stack.pop();

				// Obtain first operand from stack.
				if (stack.isEmpty())
					throw new PostFixException("Not enough operands-stack underflow");
				operand1 = stack.top();
				stack.pop();

				// Perform operation.
				if (operator.equals("/"))
					if (operand2 == 0)
						throw new PostFixException("Illegal divide by zero");
					else
						result = operand1 / operand2;
				else if (operator.equals("*"))
					result = operand1 * operand2;
				else if (operator.equals("+"))
					result = operand1 + operand2;
				else if (operator.equals("-"))
					result = operand1 - operand2;
				else if (operator.equals("^"))
					if (operand1 > operand2)
						result = operand1;
					else		//if operand2 > operand1, return operand2 OR if they are the same, return operand2 (which is the same as operand1)
						result = operand2;

				// Push result of operation onto stack.
				stack.push(result);
				
			}
		}

		// Obtain final result from stack.
		if (stack.isEmpty())
			throw new PostFixException("Not enough operands-stack underflow");
		result = stack.top();
		stack.pop();

		// Stack should now be empty.
		if (!stack.isEmpty())
			throw new PostFixException("Too many operands-operands left over");
		
		//Calculate the average of the numbers pushed
		average = average/(int)count;
		
		// Return the array.
		return result;
	}
	
	public void resetFields() {
		count = 0;
		average = 0;
		largest = 0;
		smallest = 0;
	}
}
