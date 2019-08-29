package assignment1;
import java.util.*;
import java.io.*;

public class FileDemo2 {
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        String line = null;
        String fileName = null;

        System.out.println("I will store a line of text for you.");
        System.out.println("Enter the line of text:");
        line = keyboard.nextLine( );

 		File directory = new File(".");
 		String filename[] = directory.list();
 		System.out.println("Here are the listing of all file names : ");
 		for (int i = 0; i < filename.length; i++)
 			System.out.println(filename[i]);


        System.out.println("Enter a file name to hold the line:");
        fileName = keyboard.nextLine( );
        File fileObject = new File(fileName);

        while (fileObject.exists( ))
        {
            System.out.println("There already is a file named "
                                       + fileName);
            System.out.println("Enter a different file name:");
            fileName = keyboard.nextLine( );
            fileObject = new File(fileName);
        }


         PrintWriter outputStream = null;
         outputStream = new PrintWriter(new FileOutputStream(fileName));

         System.out.println("Writing \""  + line + "\"");
         System.out.println("to the file "  + fileName);
         outputStream.println(line);

         outputStream.close( );
         System.out.println("Writing completed.");
     }
 }