package hw2;

/**
 * A ScoreCalculator keeps track of the score calculation for a time-based word
 * puzzle solving game. The score starts out at a maximum value determined by
 * the difficulty of the puzzle and decreases as time passes. The calculator is
 * initialized for a round of the game by calling <code>start</code>.
 * Thereafter, the current score can be obtained by calling
 * <code>getPossibleScore(int elapsedMillis)</code>. Note that this class only
 * performs score calculation and does not do any timekeeping; it is up to the
 * caller to keep track of the actual time and provide the elapsed time in the
 * <code>elapsedMillis</code> argument.
 * <p>
 * For this implementation, the initial maximum score is always the length of
 * the word times the fixed value <code>millisPerLetter</code>. The score is
 * reduced by 1 for each elapsed millisecond. The score may also be reduced by
 * penalties for incorrect guesses or hints.
 */
public class ScoreCalculator {
	/**
	 * Factor for determining initial maximum score
	 */
	private int millisPerLetter;
	/**
	 * Score penalty imposed for getting a hint in the game
	 */
	private int hintPenalty;
	/**
	 * Counts the number of times hint is utilized
	 */
	private int hintPenaltyCounter;
	/**
	 * Counts the number of times rescramble is utilized
	 */
	private int rescramblePenaltyCounter;
	/**
	 * Score penalty imposed for calling rescramble
	 */
	private int rescramblePenalty;
	/**
	 * Counts the number of times guess is incorrect
	 */
	private int incorrectGuessPenaltyCounter;
	/**
	 * Score penalty imposed for submitting an incorrect solution in the game
	 */
	private int incorrectGuessPenalty;
	/**
	 * Length of word for score
	 */
	private int wordLength;

	/**
	 * Constructs a ScoreCalculator for which the initial maximum score is given
	 * by <code>millisPerLetter</code> times the number of letters in a given
	 * word.
	 * 
	 * @param millisPerLetter
	 *            Factor for determining initial maximum score
	 * @param hintPenalty
	 *            Score penalty imposed for getting a hint in the game
	 * @param incorrectGuessPenalty
	 *            Score penalty imposed for submitting an incorrect solution in
	 *            the game
	 * @param rescramblePenalty
	 *            Score penalty imposed for submitting an incorrect solution in
	 *            the game
	 */
	public ScoreCalculator(int millisPerLetter, int hintPenalty, int rescramblePenalty, int incorrectGuessPenalty) {
		this.millisPerLetter = millisPerLetter;
		this.hintPenalty = hintPenalty;
		this.rescramblePenalty = rescramblePenalty;
		this.incorrectGuessPenalty = incorrectGuessPenalty;
	}

	/**
	 * Initializes this score calculator based on the given word length to start
	 * a new round. The maximum possible score is <code>millisPerLetter</code>
	 * times the word length.
	 * 
	 * @param wordLength
	 *            length of the word for the current round
	 */
	public void start(int wordLength) {
		this.wordLength = wordLength;
	}

	/**
	 * Returns the score the player would receive if the puzzle is solved in the
	 * given number of milliseconds. The returned value is the initial maximum
	 * score, less the given number of milliseconds, less any accumulated
	 * penalties. However, the returned value is never less than zero.
	 * 
	 * @param elapsedMillis
	 *            number of milliseconds it has taken the player so far
	 * @return current score for the given milliseconds
	 */
	public int getPossibleScore(int elapsedMillis) {
		// max score is length of times milliseconds per letter minus elapsed
		// time and penalties
		return (wordLength * millisPerLetter) - (elapsedMillis + 
				                                (hintPenalty * hintPenaltyCounter) +
				                                (rescramblePenalty * rescramblePenaltyCounter) +
				                                (incorrectGuessPenalty * incorrectGuessPenaltyCounter));
	}

	/**
	 * Imposes the penalty for obtaining a hint. This value will be subtracted
	 * from the next call to <code>getScore</code>.
	 */
	public void applyHintPenalty() {
		hintPenaltyCounter++;
	}

	/**
	 * Imposes the penalty for rescrambling. This value will be subtracted from
	 * the next call to <code>getScore</code>.
	 */
	public void applyRescramblePenalty() {
		rescramblePenaltyCounter++;
	}

	/**
	 * Imposes the penalty for an incorrect guess. This value will be subtracted
	 * from the next call to <code>getScore</code>.
	 */
	public void applyIncorrectGuessPenalty() {
		incorrectGuessPenaltyCounter++;
	}

}
