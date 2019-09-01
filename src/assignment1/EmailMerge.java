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
            String emailContents = "";
            int startIndex = 0;
            while (inputTemp.hasNextLine()) {
            	String emailLine = inputTemp.nextLine();
            	if (emailLine.contains("<<N>>")) {
            		int nameHolder = emailLine.indexOf("<<N>>");
            		emailContents.concat(emailLine.substring(startIndex, nameHolder));
            		emailContents.concat(name);
            		startIndex = nameHolder + 5;
            	}
            	else if (emailLine.contains("<<A>>")) {
            		int ageHolder = emailLine.indexOf("<<A>>");
            		emailContents.concat(emailLine.substring(startIndex, ageHolder));
            		emailContents.concat(age);
            		startIndex = ageHolder + 5;
            	}
            	else if (emailLine.contains("<<G>>")) {
            		int genderHolder = emailLine.indexOf("<<G>>");
            		emailContents.concat(emailLine.substring(startIndex, genderHolder));
            		startIndex = genderHolder + 5;
            	}
            }
           // emailContents.concat()
            // outputStream.println(emailContents);


           
        }
		
		//String fileName;

		
	}

}
