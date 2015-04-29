package hw3;

import java.awt.Color;

import hw3.api.IPolyomino;
import hw3.api.Position;
import hw3.impl.Block;

public class IPiece extends AbstractPiece {

	public IPiece(Position givenPosition, Color[] colors) {
		super(givenPosition);
		if (colors.length != 3){
			throw new IllegalArgumentException("Array should have 3 colors!"); 
		}
		blocks = new Block[3];

		// we'll store positions in the blocks that are relative to the
		// upper left corner
		blocks[0] = new Block(colors[0], new Position(0, 0));
		blocks[1] = new Block(colors[1], new Position(0, 1));
		blocks[2] = new Block(colors[2], new Position(0, 2));
	}

	@Override
	public Block[] getBlocks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void transform() {
		// special case, intentionally overriding transform method to do nothing
	}

	@Override
	public IPolyomino clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
