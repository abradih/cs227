package hw3;

import java.awt.Color;

import hw3.api.IPolyomino;
import hw3.api.Position;
import hw3.impl.Block;

public abstract class AbstractPiece implements IPolyomino {
	protected Position pos;
	protected Block[] blocks;

	public AbstractPiece(Position givenPosition) {
		pos = givenPosition;
	}

	@Override
	public Position getPosition() {
		return pos;
	}

	@Override
	public void initializePosition(Position givenPosition) {
		pos = givenPosition;
	}
	
	@Override
	public void initializeBlocks(Block[] givenBlocks) {
		blocks = givenBlocks;
	}
	
	@Override
	public void shiftDown() {
		pos.setRow(pos.getRow() + 1);
	}

	@Override
	public void shiftLeft() {
		pos.setCol(pos.getCol() - 1);
	}

	@Override
	public void shiftRight() {
		pos.setCol(pos.getCol() + 1);
	}

	@Override
	public void cycle() {
		// saves color of last block 
		Color c = blocks[blocks.length - 1].getColorHint();
		// set each block color to the color of previous block
		for(int i = blocks.length-1; i > 0; i--){
			blocks[i].setIcon(blocks[i-1].getColorHint());
		}
		// set first block color to that of the last color
		blocks[0].setIcon(c);
	}
	
	
	/**
	 * Returns a deep copy of this object.
	 * 
	 * @return a deep copy of this object.
	 */
	public IPolyomino clone() {
		// The built-in cloning mechanism of the Java runtime will
		// create an object of the correct runtime type.
		AbstractPiece cloned = null;
		try {
			cloned = (AbstractPiece) super.clone();
		} catch (CloneNotSupportedException e) {
			// can't happen in this case
		}

		//
		// TODO:
		//
		// Since clone() only gives us a "shallow" copy that shares
		// references with the original, we have to make copies for all
		// instance variables that are references (such as the Position
		// and Block[] attributes). See hw3.example.SamplePiece for an
		// example.
		//

		return cloned;
	}

}
