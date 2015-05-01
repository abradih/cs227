package hw3;

import hw3.api.IPolyominoGenerator;
import hw3.api.Position;
import hw3.impl.AbstractBlockGame;
import hw3.impl.GridCell;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class BlockGame extends AbstractBlockGame {

	public BlockGame(IPolyominoGenerator generator) {
		super(generator);
	}

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

				if ((i2 - 1) >= 0) {
					// left
					if (cur.matches(grid[i][i2 - 1])) {
						matches.add(new Position(i, i2 - 1));
					}
					if ((i - 1) > 0) {
						// upper left
						if (cur.matches(grid[i - 1][i2 - 1])) {
							matches.add(new Position(i - 1, i2 - 1));
						}
					}
					if ((i + 1) < grid.length) {
						// down left
						if (cur.matches(grid[i + 1][i2 - 1])) {
							matches.add(new Position(i + 1, i2 - 1));
						}
					}
				}
				if ((i2 + 1) < grid[i].length) {
					// right
					if (cur.matches(grid[i][i2 + 1])) {
						matches.add(new Position(i, i2 + 1));
					}
					if ((i - 1) > 0) {
						// upper right
						if (cur.matches(grid[i - 1][i2 + 1])) {
							matches.add(new Position(i - 1, i2 + 1));
						}
					}
					if ((i + 1) < grid.length) {
						// down right
						if (cur.matches(grid[i + 1][i2 + 1])) {
							matches.add(new Position(i + 1, i2 + 1));
						}
					}
				}
				if ((i - 1) > 0) {
					// up
					if (cur.matches(grid[i - 1][i2])) {
						matches.add(new Position(i - 1, i2));
					}
				}
				if ((i + 1) < grid.length) {
					// down
					if (cur.matches(grid[i + 1][i2])) {
						matches.add(new Position(i + 1, i2));
					}
				}

				// if there are 2 matching neighbors add the current and the
				// matches to list
				if (matches.size() > 3) {
					deadCells.addAll(matches);
				}
			}

		}

		return deadCells;
	}

	@Override
	public int determineScore() {
		// TODO Auto-generated method stub
		return 0;
	}

}
