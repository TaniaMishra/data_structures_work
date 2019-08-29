package assignment1;
import java.util.*;
import java.io.*;

public class FileDemo
{
    public static void main(String[] args) throws IOException
    {
        Scanner inputStream = null;
        PrintWriter outputStream = null;

        Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
		String inputFileName = console.next();
		System.out.print("Output file: ");
      	String outputFileName = console.next();

        inputStream = new Scanner(new FileInputStream(inputFileName));
        outputStream = new PrintWriter(new FileOutputStream(outputFileName));

        String line = null;
        int count = 0;

        while (inputStream.hasNextLine( ))
        {
            line = inputStream.nextLine( );
            count++;
            outputStream.println(count + ":" + line);
        }

        inputStream.close( );
        outputStream.close( );
    }

}
