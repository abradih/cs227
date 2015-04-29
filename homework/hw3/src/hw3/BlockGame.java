package hw3;

import java.util.ArrayList;

import hw3.api.IPolyominoGenerator;
import hw3.api.Position;
import hw3.impl.AbstractBlockGame;

public class BlockGame extends AbstractBlockGame {

	protected BlockGame(IPolyominoGenerator generator) {
		super(generator);
	}

	@Override
	public ArrayList<Position> determineCellsToCollapse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int determineScore() {
		// TODO Auto-generated method stub
		return 0;
	}


}
