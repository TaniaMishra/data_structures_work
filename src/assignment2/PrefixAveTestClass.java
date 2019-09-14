package assignment2;

import java.io.*;
import java.util.*;

public class PrefixAveTestClass {
	public static void main(String[] args) throws IOException {
		Random generator = new Random();
		PrefixAverage preAve = new PrefixAverage();
		int length = 2000;
		PrintWriter outputStream = null;
		outputStream = new PrintWriter(new FileOutputStream("AverageTest.txt"));
		
		outputStream.println("Method 1                 Method 2");
		
		while (length >= 0) {
			double[] num = new double[length];
			for (int i = 0; i < length; i++) {
				num[i] = generator.nextInt();
			}

			double[] averages = new double[length];
			
			long startTime1 = System.nanoTime();
			averages = preAve.prefixAverage1(num);
			long finishTime1 = System.nanoTime();
			long totalTime1 = finishTime1 - startTime1;
			outputStream.print(totalTime1);
			
			outputStream.print("                         ");
			
			long startTime2 = System.nanoTime();
			averages = preAve.prefixAverage2(num);
			long finishTime2 = System.nanoTime();
			long totalTime2 = finishTime2 - startTime2;
			outputStream.println(totalTime2);
			
			
			length -= 100;
		}
		
		outputStream.close();
	}
}
