package hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * A Words object is used to randomly choose words from a file. The file format
 * is one word per line.
 */
public class Words {
	/**
	 * Makes empty array list for storing words from file
	 */
	private ArrayList<String> words = new ArrayList<String>();

	/**
	 * Constructs a Words object that will use the strings from the given file.
	 * 
	 * @param filename
	 *            name of file containing words
	 * @throws FileNotFoundException
	 *             if the word file cannot be opened
	 */
	public Words(String filename) throws FileNotFoundException {
		File wordsFile = new File(filename);
		Scanner scanner = new Scanner(wordsFile);
		// while there are more lines...
		while (scanner.hasNextLine()) {
			// get the next line
			String line = scanner.nextLine();
			// adds the word to array list
			words.add(line);
		}

		// close the file
		scanner.close();
	}

	/**
	 * Get a randomly chosen word from this word list using the given
	 * <code>Random</code> object as the source of randomness. Specifically, the
	 * method returns the i-th word from the file, where i is the value returned
	 * by <code>rand.nextInt(n)</code>, <code>n</code> is total number of words,
	 * and the index i is 0-based.
	 * 
	 * @return randomly chosen word
	 * @throws FileNotFoundException
	 *             if the word file cannot be opened
	 */
	public String getWord(Random rand) throws FileNotFoundException {
		// generates a random number between 0 and length of words array
		int i = rand.nextInt(words.size());
		// returns word at random index i
		return words.get(i);
	}

}
