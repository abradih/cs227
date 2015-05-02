package hw3;

import hw3.api.IPolyominoGenerator;
import hw3.api.Position;
import hw3.impl.AbstractBlockGame;
import hw3.impl.GridCell;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Extends AbstractBlockGame to implement the game.
 * @author Amber Aldrich
 *
 */
public class BlockGame extends AbstractBlockGame {

	/**
	 * Tracks game score, the number of blocks collapsed.
	 */
	private int score;
	
	/**
	 * Creates a game with an empty grid.
	 * @param generator Game block generator.
	 */
	public BlockGame(IPolyominoGenerator generator) {
		super(generator);
	}
	
	/**
	 * Creates a game with a checkerboard grid. 
	 * @param generator Game block Generator.
	 * @param rand Generator for checkerboad. 
	 */
	public BlockGame(IPolyominoGenerator generator, Random rand) {
		super(generator);
		// make a grid starting at the bottom and moving up each row
		// for each row every other block is assigned a random color
		GridCell[][] grid = getGrid();
		int x = grid.length - 1;
		for (int i = 0; i < 7; i++) {
			int y = 0;
			if (x % 2 == 1) {
				y = 1;
			}
			while (y < grid[x].length) {
				Color c = AbstractBlockGame.COLORS[rand.nextInt(AbstractBlockGame.COLORS.length)];
				grid[x][y] = new GridCell(c);
				y += 2;
			}
			x--;
		}
	}

	@Override
	public ArrayList<Position> determineCellsToCollapse() {
		ArrayList<Position> deadCells = new ArrayList<Position>();
		GridCell[][] grid = getGrid();
		for (int i = 0; i < grid.length; i++) {
			for (int i2 = 0; i2 < grid[i].length; i2++) {
				ArrayList<Position> matches = new ArrayList<Position>();
				GridCell cur = grid[i][i2];
				matches.add(new Position(i, i2));

				if (cur != null) {
					// left
					if ((i2 - 1) >= 0) {
						if (grid[i][i2 - 1] != null && cur.matches(grid[i][i2 - 1])) {
							matches.add(new Position(i, i2 - 1));
						}
					}

					// right
					if ((i2 + 1) < grid[i].length) {
						if (grid[i][i2 + 1] != null && cur.matches(grid[i][i2 + 1])) {
							matches.add(new Position(i, i2 + 1));
						}
					}
					
					// up
					if ((i - 1) > 0) {
						if (grid[i - 1][i2] != null && cur.matches(grid[i - 1][i2])) {
							matches.add(new Position(i - 1, i2));
						}
					}
					
					// down
					if ((i + 1) < grid.length) {
						if (grid[i + 1][i2] != null && cur.matches(grid[i + 1][i2])) {
							matches.add(new Position(i + 1, i2));
						}
					}

					// if there are 2 matching neighbors add the current and the
					// matches to list
					if (matches.size() >= 3) {
						deadCells.addAll(matches);
					}
				}
			}
		}
		
		// strip duplicates
		ArrayList<Position> noDuplicates = new ArrayList<Position>();
		while (deadCells.size() > 0){
			Position p = deadCells.remove(0);
			if(!noDuplicates.contains(p)){
				noDuplicates.add(p);
			}
		}
		score = score + noDuplicates.size();
		return noDuplicates;
	}

	@Override
	public int determineScore() {
		return score;
	}
}
