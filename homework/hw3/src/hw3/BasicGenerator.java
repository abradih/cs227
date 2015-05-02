package hw3;

import java.awt.Color;
import java.util.Random;

import hw3.api.IPolyomino;
import hw3.api.IPolyominoGenerator;
import hw3.api.Position;
import hw3.impl.AbstractBlockGame;

/**
 * Randomly picks next block for game piece: Ipiece 60%, Lpiece 20% and Diagonal
 * Piece 20% of the time.
 * 
 * @author Amber Aldrich
 *
 */
public class BasicGenerator implements IPolyominoGenerator {
	/**
	 * Random number generator for picking what game piece.
	 */
	private Random random;

	/**
	 * Constructs a BasicGenerator Ipiece 60%, Lpiece 20% and Diagonal Piece 20%
	 * of the time.
	 * 
	 * @param random
	 *            the random number generator for picking game piece.
	 */
	public BasicGenerator(Random random) {
		this.random = random;
	}

	@Override
	public IPolyomino getNext() {
		int x = random.nextInt(10);
		if (x >= 0 && x <= 5) {
			Color[] c = getRandomColors(3);
			return new IPiece(new Position(-2, 5), c);
		} else if (x > 5 && x <= 7) {
			Color[] c = getRandomColors(2);
			return new DiagonalPiece(new Position(-1, 5), c);
		} else {
			Color[] c = getRandomColors(4);
			return new LPiece(new Position(-2, 5), c);
		}
	}

	/**
	 * Returns a array of random colors
	 * 
	 * @param n number of colors to return
	 * @return Returns a array of random colors
	 */
	private Color[] getRandomColors(int n) {
		Color[] c = new Color[n];
		for (int i = 0; i < c.length; i++) {
			int y = random.nextInt(AbstractBlockGame.COLORS.length);
			c[i] = AbstractBlockGame.COLORS[y];
		}
		return c;
	}
}
