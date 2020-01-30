import java.awt.Color;
import java.awt.Font;

/**
 * 
 * Thi
 * 
 * This is the interface to be implemented for each move in the game (rock,
 * paper, scissor, etc.) and it represents the particular traits of each move
 * Each move has its own unique properties: e.g Color and Font style. Each
 * MoveType class has an object that references this interface (respective to
 * their particular traits) and is used to return their particular traits when
 * called.
 * 
 * For example, the RockTraits class will always be in black font and the font
 * style of Courier.
 * 
 * This interface is the back bone of the strategy pattern I used to implement 
 * for my design.
 * 
 * @author Marcus
 *
 */
public interface MoveTraits {
	
	
	/**
	 * 
	 * @return the particular font for the type of MoveTrait
	 * e.g: rock always returns Courier in size 20.
	 */
	public Font getFont();
	/**
	 * 
	 * @return the particular color for the type of MoveTrait
	 * e.g: rock always returns the color black.
	 */
	public Color getColor();
	
	/**
	 * 
	 * @return an array of TyesOfMoves the particular MoveTrait
	 * will lose to.
	 * e.g: rock loses to paper and spock. 
	 */
	public TypesOfMoves[] getWeaknesses();
	/**
	 * 
	 * @return an array of TypeOfMoves the particular MoveTrait
	 * will beat. 
	 * e.g: rock beats scissor and lizard.
	 */
	public TypesOfMoves[] getStrengths();

	
}
