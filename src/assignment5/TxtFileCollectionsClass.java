package assignment5;

import java.io.*;
import java.util.*;

public class TxtFileCollectionsClass {
	public static void main(String[] args) throws IOException {
		//hashmap to hold a word & the number of times it is in the paragraph
		HashMap<String, Integer> frequencyMap = new HashMap<String, Integer>();
		
		//sorted set to hold individual words in the paragraph
		Set<String> wordSet = new TreeSet<String>();
		
		//checking if paragraph.txt exists (otherwise prints error message and the user has to re-run the program when it exists)
		File fileObject = new File("paragraph.txt");
		if (!(fileObject.exists())) {
			System.out.println("File 'paragraph.txt' is not found. Please make sure the file is in the correct directory path and is called 'people.txt'.");
			System.out.println("Re-run this program when 'paragraph.txt' is available.");
		}
		else {
			//if paragraph.txt exists, split each line (by space) into the words
			Scanner inputParagraph = new Scanner(new FileInputStream("paragraph.txt")); // Input of the paragraph text file
			while (inputParagraph.hasNextLine()) {
				String line = inputParagraph.nextLine(); // one line from the paragraph
				String[] words = line.split(" ");
				for (String x : words) {
					//making everything lower case & without punctuation for accurate frequency counting
					String currentWord;
					if (x.contains(".") || x.contains(",") || x.contains(";") || x.contains("!") || x.contains("?")) {
						currentWord = x.substring(0, x.length()-1);
					}
				//	else if (x.substring(0, 1) > 200) {    //check if has a capital letter at the start
						
				//	}
					
					
					
					
					boolean duplicate = wordSet.add(x);		//not already in set, will add & return true; already in set, will not add & return false
					if (duplicate == false) {		//couldn't add word because it is already in set
						int newFrequency = frequencyMap.get(x) + 1;		//add to frequency
						frequencyMap.put(x, newFrequency);
					}
					else {							//word isn't already in the set
						frequencyMap.put(x, 1);		//add word to hashmap (first time so frequency is one)
					}
				}
			}
		}
		System.out.println(frequencyMap);
		
		
		
		
	}
}
