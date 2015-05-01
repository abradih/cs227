package hw3;

import hw3.api.IPolyomino;
import hw3.api.Position;
import hw3.impl.Block;

import java.awt.Color;

public class LPiece extends AbstractPiece {

	public LPiece(Position givenPosition, Color[] colors) {
		super(givenPosition);
		if (colors.length != 4){
			throw new IllegalArgumentException("Array should have 4 colors!"); 
		}
		blocks = new Block[4];

		// we'll store positions in the blocks that are relative to the
		// upper left corner
		blocks[0] = new Block(colors[0], new Position(0, 0));
		blocks[1] = new Block(colors[1], new Position(1, 0));
		blocks[2] = new Block(colors[2], new Position(1, 1));
		blocks[3] = new Block(colors[3], new Position(1, 2));
	}

	@Override
	public Block[] getBlocks() {
		Block[] toReturn = new Block[4];

		// we need to return absolute positions in the grid, so add to
		// row and column of upper left corner
		Position p = new Position(blocks[0].getPosition());
		p.setRow(p.getRow() + pos.getRow());
		p.setCol(p.getCol() + pos.getCol());
		toReturn[0] = new Block(blocks[0].getColorHint(), p);

		p = new Position(blocks[1].getPosition());
		p.setRow(p.getRow() + pos.getRow());
		p.setCol(p.getCol() + pos.getCol());
		toReturn[1] = new Block(blocks[1].getColorHint(), p);

		p = new Position(blocks[2].getPosition());
		p.setRow(p.getRow() + pos.getRow());
		p.setCol(p.getCol() + pos.getCol());
		toReturn[2] = new Block(blocks[2].getColorHint(), p);
		
		p = new Position(blocks[3].getPosition());
		p.setRow(p.getRow() + pos.getRow());
		p.setCol(p.getCol() + pos.getCol());
		toReturn[3] = new Block(blocks[3].getColorHint(), p);
		
		return toReturn;
	}

	@Override
	public IPolyomino clone() {
		LPiece cloned = (LPiece) super.clone();
		cloned.pos = new Position(pos);
		cloned.blocks = new Block[4];
		cloned.blocks[0] = new Block(blocks[0]);
		cloned.blocks[1] = new Block(blocks[1]);
		cloned.blocks[2] = new Block(blocks[2]);
		cloned.blocks[3] = new Block(blocks[3]);
		return cloned;
	}


	@Override
	public void transform() {
		blocks[0].setPosition(new Position(0,2));
	}
	
}
