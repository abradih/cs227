package test;

import hw2.ScoreCalculator;

public class TestScoreCalculator {

	public static void main(String[] args) {
		// millisPerLetter = 5000 (5 seconds)
		// hint penalty = 2 seconds
		// rescramble penalty = 1/10 of a second
		// incorrect guess penalty = 1 second
		ScoreCalculator sc = new ScoreCalculator(5000, 2000, 100, 1000);

		sc.start(10); // for a ten-letter word
		System.out.println(sc.getPossibleScore(0));
		System.out.println("Expected 50000");
		System.out.println(sc.getPossibleScore(1000));
		System.out.println("Expected 49000");
		System.out.println(sc.getPossibleScore(20000));
		System.out.println("Expected 30000");

		sc.applyHintPenalty();
		sc.applyIncorrectGuessPenalty();
		sc.applyRescramblePenalty();
		System.out.println(sc.getPossibleScore(1000));
		System.out.println("Expected 45900");

	}

}
