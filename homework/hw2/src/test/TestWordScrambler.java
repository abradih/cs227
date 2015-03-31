package test;

import hw2.WordScrambler;

import java.util.Random;

import util.PermutationGenerator;

public class TestWordScrambler {

	public static void main(String[] args) {
		Random rand = new Random(137);
		PermutationGenerator gen = new PermutationGenerator(rand);
		String result = WordScrambler.scramble("ABCD", gen);
		System.out.println(result);
		System.out.println("Expected BDAC");
	}

}
