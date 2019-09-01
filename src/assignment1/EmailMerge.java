package assignment1;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class EmailMerge {

	public static void main(String[] args) throws IOException {
		Scanner inputPeople = new Scanner(new FileInputStream("people.txt")); //Input of the people file. Format: name age gender
		ArrayList<PeopleInfo> people = new ArrayList<PeopleInfo>();
		
		//loop through the people file by each line
		int index = 0;
		while (inputPeople.hasNextLine()) {
            String line = inputPeople.nextLine();	//line of info for one person
            
            //Finding name, age, and gender by getting a substring from the line. Storing info in a class & in an arraylist of the class
            int space1 = line.indexOf(" ");
            int space2 = line.indexOf(" ", space1+1);
            String name = line.substring(0, space1);
            String age = line.substring(space1+1, space2);
            String gender = line.substring(space2+1);
            people.add(new PeopleInfo(name, age, gender));
            
            //Creating output file with name. If name is already used, add a number to the file name
            boolean repeatName = false;
            for (int i = 0; i < people.size(); i++) {
            	if (i != index) {
                	if (people.get(i).getName().equals(people.get(index).getName())) {
                		repeatName = true;
                		people.get(i).addRepeat();
                		people.get(index).addRepeat();
                	}
            	}
            }
            String fileName = "placeholder";
            if (repeatName == false) {
            	fileName = people.get(index).getName() + ".txt";
            }
            else {
            	fileName = people.get(index).getName() + "-" + people.get(index).getRepeats() + ".txt";
            }
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(fileName));

            
            
            //Input of the email template file. Placeholders: <<N>> = name, <<A>> = age, <<G>>
    		Scanner inputTemp = new Scanner(new FileInputStream("template.txt"));
    		
    		//loop through the email template file by line
            while (inputTemp.hasNextLine()) {
            	String emailLine = inputTemp.nextLine();	//one line from the template
            	int startIndex = 0;
            	
            	//checks whether placeholder for name is in this line - if so, prints from start index to placeholder and the name 
            	if (emailLine.contains("<<N>>")) {
            		int nameHolder = emailLine.indexOf("<<N>>");
            		outputStream.print(emailLine.substring(startIndex, nameHolder));
            		outputStream.print(people.get(index).getName());
            		System.out.print(emailLine.substring(startIndex, nameHolder));
            		System.out.print(people.get(index).getName());
            		startIndex = nameHolder + 5;			//changes position of startIndex to immediately after placeholder
            	}
            	
            	//checks whether placeholder for age is in this line - if so, prints from start index to placeholder and the age 
            	if (emailLine.contains("<<A>>")) {
            		int ageHolder = emailLine.indexOf("<<A>>");
            		outputStream.print(emailLine.substring(startIndex, ageHolder));
            		outputStream.print(people.get(index).getAge());
            		System.out.print(emailLine.substring(startIndex, ageHolder));
            		System.out.print(people.get(index).getAge());
            		startIndex = ageHolder + 5;			//changes position of startIndex to immediately after placeholder
            	}
            	
            	//checks whether placeholder for gender is in this line - if so, prints from start index to placeholder and the gender
            	if (emailLine.contains("<<G>>")) {
            		int genderHolder = emailLine.indexOf("<<G>>");
            		outputStream.print(emailLine.substring(startIndex, genderHolder));
            		outputStream.print(people.get(index).getGender());
            		System.out.print(emailLine.substring(startIndex, genderHolder));
            		System.out.print(people.get(index).getGender());
            		startIndex = genderHolder + 5;			//changes position of startIndex to immediately after placeholder
            	}
            	//prints from startIndex to the end of the line (either the whole line - if no placeholders in that line, or from the last placeholder to the end of the line)
            	outputStream.println(emailLine.substring(startIndex));
            	System.out.println(emailLine.substring(startIndex));
            }
    		outputStream.close();
    		inputTemp.close();
        	index++;

        }
		inputPeople.close();
	}

}
