import java.awt.Color;
import java.awt.Font;


/**
 * This class represents the particular traits of a Spock/
 * For example, it will always be in the Dialog font and 
 * in the color ligh cyan.
 * 
 * @author Marcus 
 *
 */
public class SpockTraits implements MoveTraits{
	/**
	 * @return the particular font for Rocks
	 */
	public Font getFont() {
		return new Font("Dialog", Font.ITALIC, 20);
	}
	
	/**
	 * @return the particular color for rocks.
	 */
	public Color getColor() {
		return Color.CYAN;
	}
	/**
	 * @return an array of TypesOfMoves that contains the weaknesses of this
	 * MoveType.
	 */
	public TypesOfMoves[] getWeaknesses() {
		TypesOfMoves[] moves = {TypesOfMoves.PAPER, TypesOfMoves.LIZARD, TypesOfMoves.DEATHSTAR};
		return moves;
	}
	/**
	 * @return an array of TypesOfMoves that contains the strengths of this
	 * MoveType.
	 */
	public TypesOfMoves[] getStrengths() {
		TypesOfMoves[] moves = {TypesOfMoves.ROCK, TypesOfMoves.SCISSOR};
		return moves;
	}
}
