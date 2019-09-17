package assignment3;

import java.util.*;

public class ClearTestClass {
	public static void main(String[] args) {
		ArrayBoundedStack stack = new ArrayBoundedStack(20);
		Random rand = new Random();
		
		//fill stack with random values
		for (int i = 0; i < 20; i++) {
			stack.push(rand.nextInt());
		}
		//test remove method with 4 values, 12 values, 6 values (should throw exception)
		System.out.println("Top-Index (no changes) " + stack.topIndex);
		stack.clear();
		System.out.println("Top-Index (cleared) " + stack.topIndex);
		stack.clear();
	}
}
