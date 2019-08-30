package assignment1;

import java.util.Scanner;
import java.io.*;

public class EmailMerge {

	public static void main(String[] args) throws IOException {
		Scanner inputPeople = new Scanner(new FileInputStream("people.txt"));
		Scanner inputTemp = new Scanner(new FileInputStream("template.txt"));
		
		while (inputPeople.hasNextLine( ))
        {
            System.out.println(inputPeople.nextLine( ));
           
        }
		
		//String fileName;
        //PrintWriter outputStream = new PrintWriter(new FileOutputStream(fileName));

		
	}

}
