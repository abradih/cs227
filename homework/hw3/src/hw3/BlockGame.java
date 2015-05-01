package hw3;

import java.util.ArrayList;

import hw3.api.IPolyominoGenerator;
import hw3.api.Position;
import hw3.impl.AbstractBlockGame;
import hw3.impl.GridCell;

public class BlockGame extends AbstractBlockGame {

	protected BlockGame(IPolyominoGenerator generator) {
		super(generator);
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
