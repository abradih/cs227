package hw2;

import util.PermutationGenerator;

/**
 * A WordPair encapsulates two representations of a given word - its "real"
 * form, which does not change, and a "scrambled" form in which the letters are
 * rearranged. The scrambled form of the word may be updated by calls to the
 * methods <code>moveLeft</code>, <code>moveRight</code>,
 * <code>doLetterHint</code>, and <code>rescramble</code>.
 */
public class WordPair {
	/**
	 * Stores real word
	 */
	private String realWord;
	/**
	 * Stores scrabbled word
	 */
	private String scrambledWord;

	/**
	 * Constructs an instance of WordPair with the given strings. This
	 * constructor does not check whether the given scrambled word is a valid
	 * rearrangement of the given real word, but this can be checked by a
	 * subsequent call to the method <code>isSolutionPossible</code>.
	 * 
	 * @param givenRealWord
	 *            the real word
	 * @param givenScrambledWord
	 *            the word with characters rearranged
	 */
	public WordPair(String givenRealWord, String givenScrambledWord) {
		realWord = givenRealWord;
		scrambledWord = givenScrambledWord;
	}

	/**
	 * Returns the current scrambled form of the word in upper case.
	 * 
	 * @return scrambled form of the word.
	 */
	public String getScrambledWord() {
		return scrambledWord;
	}

	/**
	 * Returns the real word in upper case.
	 * 
	 * @return the real word
	 */
	public String getRealWord() {
		return realWord;
	}

	/**
	 * Modifies the scrambled word by moving the character at position
	 * <code>index</code> to the right the given number of spaces. Intervening
	 * characters are shifted left. For example, if the scrambled word is
	 * "ABCDEFG", then after moveRight(2, 3) the scrambled word should be
	 * "ABDEFCG". This method should do nothing if the index is out of range, if
	 * <code>howFar</code> is negative, if the index plus <code>howFar</code> is
	 * out of range, or if the index is less than
	 * <code>getNumLetterHints()</code>.
	 * 
	 * @param index
	 *            zero-based index of the character to be moved
	 * @param howFar
	 *            number of spaces to the right to move the character
	 */
	public void moveRight(int index, int howFar) {
		// if index is in range of word
		if (index < scrambledWord.length()) {
			// if howFar is not negative
			if (howFar > 0) {
				// if index plus howFar is within the range of word
				if (index + howFar < scrambledWord.length()) {
					// if the the letter is not revealed by hint
					if (index >= getNumLetterHints()) {
						String result = "";
						// if the index is not first character
						if (index > 0) {
							// stores string up to index
							result = scrambledWord.substring(0, index - 1);
						}
						// stores character to be moved
						char toMove = scrambledWord.charAt(index);
						// adds onto stored string to the point in which index
						// character is to be added
						result = result + scrambledWord.substring(index + 1, index + howFar);
						// adds the index character to end of result
						result = result + toMove;
						// adds the rest of the string after the addition
						result = result + scrambledWord.substring(index + howFar, scrambledWord.length());
						// stores the result as scrambledWord
						scrambledWord = result;
					}
				}
			}
		}
	}

	/**
	 * Modifies the scrambled word by moving the character at position
	 * <code>index</code> to the left the given number of spaces. Intervening
	 * characters are shifted right. For example, if the scrambled word is
	 * "ABCDEFG", then after moveLeft(5, 3) the scrambled word should be
	 * "ABFCDEG". This method should do nothing if the index is out of range, if
	 * <code>howFar</code> is negative, if the index minus <code>howFar</code>
	 * is out of range, or if the index index minus <code>howFar</code> is less
	 * than <code>getNumLetterHints()</code>.
	 * 
	 * @param index
	 *            zero-based index of the character to be moved
	 * @param howFar
	 *            number of spaces to the left to move the character
	 */
	public void moveLeft(int index, int howFar) {
		// if index is in range of word
		if (index < scrambledWord.length()) {
			// if howFar is not negative
			if (howFar > 0) {
				// if index minus howFar is within the range of word
				if (index - howFar >= 0) {
					// if the the letter is not revealed by hint
					if (index >= getNumLetterHints()) {
						// stores character to be moved
						String result = "";
						char toMove = scrambledWord.charAt(index);
						// stores end of string from word
						result = scrambledWord.substring(index + 1, scrambledWord.length());
						// adds index character then characters between howFar
						// and index then the end of the word
						result = toMove + scrambledWord.substring(index - howFar, index) + result;
						// if there characters before the moved character
						if (index - howFar > 0) {
							// adds the beginning of the word to result
							result = scrambledWord.substring(0, index - howFar - 1) + result;
						}
						// stores the result as scrambledWord
						scrambledWord = result;
					}
				}
			}
		}
	}

	/**
	 * Returns the number of letters at the beginning of the scrambled word
	 * whose positions are currently fixed by previous calls to
	 * <code>letterHint()</code>.
	 * 
	 * @return number of fixed characters at the beginning of the scrambled word
	 */
	public int getNumLetterHints() {
		// TODO
		return 0;
	}

	/**
	 * Applies a hint by placing a correct character at the position
	 * <code>p</code>, where <code>p = getNumLetterHints()</code> is the number
	 * of characters that have already been placed in the correct position by
	 * previous calls to this method. Specifically, this method searches to the
	 * right starting at index <code>p</code> until it finds the first
	 * occurrence of the correct character, and then swaps that character into
	 * position <code>p</code>. After this method has been called n times, the
	 * first n letters of the scrambled word are correct and are not moved again
	 * by any subsequent method calls.
	 * <p>
	 * For example: if the real word is "AARDVARK" and the scrambled word is
	 * "DVRAKARA", then after one call to <code>doLetterHint</code>, the
	 * scrambled word is "AVRDKARA" (D is swapped with first A). After two calls
	 * to <code>doLetterHint</code>, the scrambled word is "AARDKVRA" (V is
	 * swapped with the second A). After three calls to
	 * <code>doLetterHint</code>, the scrambled word is still "AARDKVRA" (R is
	 * swapped with itself). However <code>getNumLetterHints</code> will now
	 * return 3, and the characters at indices 0, 1, and 2 will be not be moved.
	 */
	public void doLetterHint() {
		// TODO
	}

	/**
	 * Rescrambles the non-fixed letters in the scrambled using the given
	 * permutation generator. Letters to the left of the index
	 * <code>getNumLetterHints()</code> are not moved. This method should update
	 * the scrambled word with the value of
	 * 
	 * <pre>
	 * WordScrambler.scramble(getScrambledWord(), getNumLetterHints(), gen);
	 * </pre>
	 * 
	 * )
	 * 
	 * @param gen
	 *            permutation generator for scrambling the non-fixed letters
	 */
	public void rescramble(PermutationGenerator gen) {
		// TODO
	}

	/**
	 * Determines whether the scrambled word is a valid rearrangement of the
	 * real word (disregarding case).
	 * 
	 * @return true if it is possible to rearrange the characters in the
	 *         scrambled word to obtain the real word
	 */
	public boolean isSolutionPossible() {
		// TODO
		return true;
	}

	/**
	 * Determines whether the current scrambled word is equal to the real word
	 * (disregarding case).
	 * 
	 * @return true if scrambled word and real word are the same, false
	 *         otherwise
	 */
	public boolean checkSolution() {
		// TODO
		return false;
	}

	/**
	 * Determines whether the given string is equal to the real word
	 * (disregarding case). Does not modify the scrambled word.
	 * 
	 * @return true if given word and real word are the same, false otherwise
	 */
	public boolean checkSolution(String solution) {
		// TODO
		return false;
	}
}
