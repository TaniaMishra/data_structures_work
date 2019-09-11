package assignment2;

import java.util.Random;

public class PrefixAveTest1 {
	public static void main(String[] args) {
		int length = 100;
		Random generator = new Random();
		PrefixAverage preAve = new PrefixAverage();
		
		double[] num = new double[length];
		for (int i = 0; i < length; i++) {
			num[i] = generator.nextInt();
		}
		
		
		double[] averages = new double[length];
		long startTime = System.nanoTime();
		averages = preAve.prefixAverage1(num);
		long finishTime = System.nanoTime();
		long totalTime = finishTime-startTime;
		
		System.out.println(totalTime + " nanoseconds");

	}
}
