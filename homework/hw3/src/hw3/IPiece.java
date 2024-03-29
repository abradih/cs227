package hw3;

import java.awt.Color;

import hw3.api.IPolyomino;
import hw3.api.Position;
import hw3.impl.Block;

/**
 * Defines a I game piece.
 * 
 * @author Amber Aldrich
 *
 */
public class IPiece extends AbstractPiece {
	/**
	 * Creates a I game piece.
	 * 
	 * @param givenPosition
	 *            Defines starting position of the game piece.
	 * @param colors
	 *            Defines the colors of each of the blocks in the game piece.
	 */
	public IPiece(Position givenPosition, Color[] colors) {
		super(givenPosition);
		if (colors.length != 3) {
			throw new IllegalArgumentException("Array should have 3 colors!");
		}
		blocks = new Block[3];

		// we'll store positions in the blocks that are relative to the
		// upper left corner
		blocks[0] = new Block(colors[0], new Position(0, 0));
		blocks[1] = new Block(colors[1], new Position(1, 0));
		blocks[2] = new Block(colors[2], new Position(2, 0));
	}

	@Override
	public Block[] getBlocks() {
		Block[] toReturn = new Block[3];

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
	
		return toReturn;
	}

	@Override
	public void transform() {
		// special case, intentionally overriding transform method to do nothing
	}

	@Override
	public IPolyomino clone() {
		// The built-in cloning mechanism of the Java runtime will
		// create an object of the correct runtime type.
		IPiece cloned = (IPiece) super.clone();
		cloned.pos = new Position(pos);
		cloned.blocks = new Block[3];
		cloned.blocks[0] = new Block(blocks[0]);
		cloned.blocks[1] = new Block(blocks[1]);
		cloned.blocks[2] = new Block(blocks[2]);

		return cloned;
	}

}
