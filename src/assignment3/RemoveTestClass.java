package assignment3;

import java.util.*;

public class RemoveTestClass {
	public static void main(String[] args) {
		ArrayBoundedStack stack = new ArrayBoundedStack(20);
		Random rand = new Random();
		
		//fill stack with random values
		for (int i = 0; i < 20; i++) {
			stack.push(rand.nextInt());
		}
		//test remove method with 4 values, 12 values, 6 values (should throw exception)
		System.out.println("Top-Index (no changes) " + stack.topIndex);
		stack.remove(4);
		System.out.println("Top-Index (remove 4) " + stack.topIndex);
		stack.remove(12);
		System.out.println("Top-Index (remove 12) " + stack.topIndex);
		stack.remove(6);
		
	}

}
