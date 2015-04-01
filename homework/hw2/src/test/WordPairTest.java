package test;

import hw2.WordPair;

public class WordPairTest {
	public static void main(String[] args) {
		WordPair wp = new WordPair("CAT", "TCE");
		// System.out.println(wp.getScrambledWord());
		// System.out.println("Expected NTAGPEGL");
		// wp.moveRight(0, 6); // move character 0, six spaces to right
		// System.out.println(wp.getScrambledWord());
		// System.out.println("Expected TAGPEGNL");
		// wp.moveLeft(4, 0); // move character 4, four spaces to left
		// System.out.println(wp.getScrambledWord());
		// System.out.println("");
//		wp.doLetterHint();
//		System.out.println(wp.getScrambledWord());
////		System.out.println("Expected ETAGPNGL");;
////		System.out.println(wp.getScrambledWord());
//		System.out.println("CTA".equals(wp.getScrambledWord()));
//		wp.doLetterHint();
//		System.out.println("CAT".equals(wp.getScrambledWord()));
//		wp.doLetterHint();
//		System.out.println("CAT".equals(wp.getScrambledWord()));
//	
		System.out.println(wp.isSolutionPossible());
	}
}