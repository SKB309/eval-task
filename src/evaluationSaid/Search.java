package evaluationSaid;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Search {

	static void minue() {

		System.out.println("************************************");
		System.out.println(" 1- Search API information  ");
		System.out.println(" 0 - Exit  ");
		System.out.println("************************************");

	}

	static void search() throws FileNotFoundException {
		boolean isExit = true;
		while (isExit) {
			Scanner sc = new Scanner(System.in);

			System.out.println("**********************************");
			// Reading the word to be found from the user
			System.out.println("Enter the word you want to search ");
			String input = sc.next();

			// consuming the <enter> from input above
			sc.nextLine();
			boolean word2 = false;
			int wordCount = 0;

			// Reading the String of the file
			Scanner sc1 = new Scanner(new FileInputStream("evaluationFile.txt"));
			while (sc1.hasNextLine()) {
				String word1 = sc1.nextLine();
//     System.out.println(line);
				if (word1.indexOf(input) != -1) {
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
			System.out.println("if you want to search another word press 1 and 2 to exit ");
			Integer s = sc.nextInt();
			if (s == 1) {
				isExit = true;
			} else if (s == 2) {
				isExit = false;
				System.out.println("Good Bye");
			}

		}
	}

	static void exitMassege() {

		System.out.println("Good Bay & See You Agin");

	}

	public static void main(String args[]) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);

		boolean exit = true;

		while (exit) {

			minue();
			int option = sc.nextInt();

			switch (option) {

			case 1:

				search();

				break;

			case 0:

				exitMassege();
				exit = false;

				break;

			default:

			}
		}
	}
}
