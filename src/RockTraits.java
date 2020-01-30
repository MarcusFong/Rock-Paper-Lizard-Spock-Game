import java.awt.Color;
import java.awt.Font;

/**
 * This class represents the particular traits of a Rock/
 * For example, it will always be in the Courier font and 
 * in the color black.
 * 
 * @author Marcus 
 *
 */
public class RockTraits implements MoveTraits{
	
	/**
	 * @return the particular font for Rocks
	 */
	public Font getFont() {
		return new Font("Courier", Font.BOLD, 20);
	}
	
	/**
	 * @return the particular color for rocks.
	 */
	public Color getColor() {
		return Color.BLACK;
	}
	/**
	 * @return an array of TypesOfMoves that contains the weaknesses of this
	 * MoveType.
	 */
	public TypesOfMoves[] getWeaknesses() {
		TypesOfMoves[] moves = {TypesOfMoves.PAPER, TypesOfMoves.SPOCK, TypesOfMoves.DEATHSTAR};
		return moves;
	}

	/**
	 * @return an array of TypesOfMoves that contains the strengths of this
	 * MoveType.
	 */
	public TypesOfMoves[] getStrengths() {
		TypesOfMoves[] moves = {TypesOfMoves.SCISSOR, TypesOfMoves.LIZARD};
		return moves;
	}

}
