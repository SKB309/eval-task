package evaluationSaid;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Search {

	public static void main(String args[]) throws FileNotFoundException {
		// Reading the word to be found from the user

		Scanner sc = new Scanner(System.in);

		boolean exit = false;

		do {

			System.out.println("**********************************");

			System.out.println("Enter the word you want to search ");
			String input = sc.next();
			boolean word2 = false;
			int wordCount = 0;

			// Reading the String of the file
			Scanner sc1 = new Scanner(new FileInputStream("evaluationFile.txt"));
			while (sc1.hasNextLine()) {
				String word1 = sc1.nextLine();
//         System.out.println(line);
				if (word1.indexOf(input)!= -1) {
					word2 = true;
					wordCount = wordCount + 1;
				}
			}
			if (word2) {
				System.out.println("File contains the  word");
				System.out.println("Number of word is: " + wordCount);
				System.out.println("__________________________________");

			} else {
				System.out.println("File does not contain the word");
				System.out.println("__________________________________");

			}
		} while (exit = true);
	}
}
