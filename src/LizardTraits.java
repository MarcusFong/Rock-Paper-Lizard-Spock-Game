import java.awt.Color;
import java.awt.Font;


/**
 * This class represents the particular traits of a Lizard/
 * For example, it will always be in the Courier font and 
 * in the color green.
 * 
 * @author Marcus 
 *
 */

public class LizardTraits implements MoveTraits{
	/**
	 * @return the particular font for Rocks
	 */
	public Font getFont() {
		return new Font("Helvetica", Font.ITALIC, 20);
	}
	
	/**
	 * @return the particular color for rocks.
	 */
	public Color getColor() {
		return Color.GREEN;
	}
	/**
	 * @return an array of TypesOfMoves that contains the weaknesses of this
	 * MoveType.
	 */
	public TypesOfMoves[] getWeaknesses() {
		TypesOfMoves[] moves = {TypesOfMoves.ROCK, TypesOfMoves.SCISSOR, TypesOfMoves.DEATHSTAR};
		return moves;
	}
	/**
	 * @return an array of TypesOfMoves that contains the strengths of this
	 * MoveType.
	 */
	public TypesOfMoves[] getStrengths() {
		TypesOfMoves[] moves = {TypesOfMoves.SPOCK, TypesOfMoves.PAPER};
		return moves;
	}
}
