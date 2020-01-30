import java.awt.Color;
import java.awt.Font;

/**
 * This class represents the particular traits of a Scissor/
 * For example, it will always be in the Courier font and 
 * in the color red.
 * 
 * @author Marcus 
 *
 */
public class ScissorTraits implements MoveTraits{
	/**
	 * @return the particular font for Rocks
	 */
	public Font getFont() {
		return new Font("SansSerif", Font.ITALIC, 20);
	}
	
	/**
	 * @return the particular color for rocks.
	 */
	public Color getColor() {
		return Color.red;
	}
	/**
	 * @return an array of TypesOfMoves that contains the weaknesses of this
	 * MoveType.
	 */
	public TypesOfMoves[] getWeaknesses() {
		TypesOfMoves[] moves = {TypesOfMoves.ROCK, TypesOfMoves.SPOCK, TypesOfMoves.DEATHSTAR};
		return moves;
	}
	/**
	 * @return an array of TypesOfMoves that contains the strengths of this
	 * MoveType.
	 */
	public TypesOfMoves[] getStrengths() {
		TypesOfMoves[] moves = {TypesOfMoves.PAPER, TypesOfMoves.LIZARD};
		return moves;
	}
}
