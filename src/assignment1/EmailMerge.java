package assignment1;

import java.util.Scanner;
import java.io.*;

public class EmailMerge {

	public static void main(String[] args) throws IOException {
		Scanner inputPeople = new Scanner(new FileInputStream("people.txt"));
		Scanner inputTemp = new Scanner(new FileInputStream("template.txt"));
		
		while (inputPeople.hasNextLine())
        {
            String line = inputPeople.nextLine();
            int space1 = line.indexOf(" ");
            int space2 = line.indexOf(" ", space1+1);
            String name = line.substring(0, space1);
            String age = line.substring(space1+1, space2);
            String gender = line.substring(space2+1);
            File fileObject = new File(name);
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(name));
            //String emailContents =
            // outputStream.println();


           
        }
		
		//String fileName;

		
	}

}
