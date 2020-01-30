import java.awt.Color;
import java.awt.Font;
/**
 * 
 * This class represents the particular traits of a DeathStar. 
 * It has no weaknesses and destroys everything it encounters :(.
 * 
 * @author Marcus
 *
 */
public class DeathStarTraits implements MoveTraits{
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
		return Color.LIGHT_GRAY;
	}
	/**
	 * The only weakness to the Death Star is Luke Skywalker, and he
	 * is unfortunately not in this game :(.
	 */
	public TypesOfMoves[] getWeaknesses() {
		TypesOfMoves[] moves = {};
		return moves;
	}

	/**
	 * The Death Star can kill everything!
	 */
	public TypesOfMoves[] getStrengths() {
		TypesOfMoves[] moves = {TypesOfMoves.ROCK, TypesOfMoves.PAPER, TypesOfMoves.SCISSOR
								, TypesOfMoves.LIZARD, TypesOfMoves.SPOCK};
		return moves;
	}
}
