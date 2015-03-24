package lab8;

import java.util.Random;

import lab8.Card.Suit;

/**
 * Class representing a standard 52-card deck of playing cards from which cards
 * can be selected at random.
 */
public class Deck {
	/**
	 * The cards comprising this deck.
	 */
	private Card[] cards;

	/**
	 * The random number generator to use for selecting cards.
	 */
	private Random rand;

	/**
	 * Constructs a new deck with a default random number generator.
	 */
	public Deck() {
		rand = new Random();
		init();
	}

	/**
	 * Constructs a new deck with the given random number generator.
	 */
	public Deck(Random givenGenerator) {
		rand = givenGenerator;
		init();
	}

	/**
	 * Returns a new array containing k elements selected at random from this
	 * deck.
	 */
	public Card[] select(int k) {
		Card[] hand = new Card[k];
		int n = 52;
		for (int i = 0; i < k; i += 1) {

			// First, choose an random index in the range 0 through 51.
			int index = rand.nextInt(n);

			// Exchange that element with the last one.
			Card temp = cards[n-1];
			hand[i] = cards[index]; // saves the card for the hand
			cards[n-1] = cards[index];
			cards[index] = temp;
			n = n - 1;

		}
		return hand;
	}

	public Card[] selectGood(int k) {
		Card[] hand = new Card[k];
		int n = 52;
		for (int i = 0; i < k; i += 1) {

			// First, choose an random index in the range 0 through 51.
			int index = rand.nextInt(n);

			while(cards[index].getRank() < 10){
				index = rand.nextInt(n);
			}
			
			// Exchange that element with the last one.
			Card temp = cards[n-1];
			hand[i] = cards[index]; // saves the card for the hand
			cards[n-1] = cards[index];
			cards[index] = temp;
			n = n-1;

		}
		return hand;
	}

	/**
	 * Initializes a new deck of 52 cards.
	 */
	private void init() {
		cards = new Card[52];
		int index = 0;
		for (int rank = 1; rank <= 13; ++rank) {
			cards[index] = new Card(rank, Suit.CLUBS);
			index += 1;
			cards[index] = new Card(rank, Suit.DIAMONDS);
			index += 1;
			cards[index] = new Card(rank, Suit.HEARTS);
			index += 1;
			cards[index] = new Card(rank, Suit.SPADES);
			index += 1;
		}

	}
}