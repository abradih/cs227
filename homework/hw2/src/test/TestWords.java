package test;

import hw2.Words;

import java.io.FileNotFoundException;
import java.util.Random;

public class TestWords {

	public static void main(String[] args) throws FileNotFoundException {
		Words wordList = new Words("words.txt");
		Random rand = new Random(17);
		String aWord = wordList.getWord(rand);
		System.out.println(aWord);
		System.out.println("Expected: bereft");
	}

}
