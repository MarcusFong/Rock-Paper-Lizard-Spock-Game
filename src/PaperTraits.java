import java.awt.Color;
import java.awt.Font;

/**
 * This class represents the particular traits of a Paper/
 * For example, it will always be in the Times New Roman font and 
 * in the color magenta.
 * 
 * @author Marcus 
 *
 */
public class PaperTraits implements MoveTraits {

	/**
	 * @return the particular font for Rocks
	 */
	public Font getFont() {
		return new Font("TimesRoman", Font.BOLD, 20);
	}
	
	/**
	 * @return the particular color for rocks.
	 */
	public Color getColor() {
		return Color.MAGENTA;
	}
	/**
	 * @return an array of TypesOfMoves that contains the weaknesses of this
	 * MoveType.
	 */
	public TypesOfMoves[] getWeaknesses() {
		TypesOfMoves[] moves = {TypesOfMoves.SCISSOR, TypesOfMoves.LIZARD, TypesOfMoves.DEATHSTAR};
		return moves;
	}
	/**
	 * @return an array of TypesOfMoves that contains the strengths of this
	 * MoveType.
	 */
	public TypesOfMoves[] getStrengths() {
		TypesOfMoves[] moves = {TypesOfMoves.ROCK, TypesOfMoves.SPOCK};
		return moves;	}
	
}
