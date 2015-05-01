package hw3;

import java.awt.Color;

import hw3.api.IPolyomino;
import hw3.api.Position;
import hw3.impl.Block;

public class DiagonalPiece extends AbstractPiece {

	public DiagonalPiece(Position givenPosition, Color[] colors) {
		super(givenPosition);
		if (colors.length != 2) {
			throw new IllegalArgumentException("Array should have 2 colors!");
		}
		blocks = new Block[2];

		// we'll store positions in the blocks that are relative to the
		// upper left corner
		blocks[0] = new Block(colors[0], new Position(0, 0));
		blocks[1] = new Block(colors[1], new Position(1, 1));
	}

	@Override
	public Block[] getBlocks() {
		Block[] toReturn = new Block[2];

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

		return toReturn;
	}

	@Override
	public IPolyomino clone() {
		DiagonalPiece cloned = (DiagonalPiece) super.clone();
		cloned.pos = new Position(pos);
		cloned.blocks = new Block[2];
		cloned.blocks[0] = new Block(blocks[0]);
		cloned.blocks[1] = new Block(blocks[1]);
		return cloned;
	}

	@Override
	public void transform() {
		if (blocks[0].getPosition().getRow() == 0 && blocks[0].getPosition().getCol() == 0) {
			blocks[0].setPosition(new Position(0, 1));
			blocks[1].setPosition(new Position(1, 0));
		} else {
			blocks[0].setPosition(new Position(0, 0));
			blocks[1].setPosition(new Position(1, 1));
		}
	}

}
