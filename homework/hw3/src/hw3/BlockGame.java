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
		for (int i = 1; i < grid.length - 1; i++) {
			for (int i2 = 1; i2 < grid[i].length - 1; i2++) {
				ArrayList<Position> matches = new ArrayList<Position>();
				GridCell cur = grid[i][i2];
				matches.add(new Position(i,i2));
				// left
				if (cur.matches(grid[i][i2 - 1])) {
					matches.add(new Position(i,i2 - 1));
				}
				// right
				if (cur.matches(grid[i][i2 + 1])) {
					matches.add(new Position(i,i2 + 1));
				}
				// up
				if (cur.matches(grid[i - 1][i2])) {
					matches.add(new Position(i - 1,i2));
				}
				// down
				if (cur.matches(grid[i + 1][i2])) {
					matches.add(new Position(i + 1,i2));
				}
				// upper left
				if (cur.matches(grid[i - 1][i2 - 1])) {
					matches.add(new Position(i - 1,i2 - 1));
				}
				// upper right
				if (cur.matches(grid[i - 1][i2 + 1])) {
					matches.add(new Position(i - 1,i2 + 1));
				}
				// down left
				if (cur.matches(grid[i + 1][i2 - 1])) {
					matches.add(new Position(i + 1,i2 - 1));
				}
				// down right
				if (cur.matches(grid[i + 1][i2 + 1])) {
					matches.add(new Position(i + 1,i2 + 1));
				}
				// if there are 2 matching neighbors add the current and the matches to list
				if(matches.size() > 3){
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
