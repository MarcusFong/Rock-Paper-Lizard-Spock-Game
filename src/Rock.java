import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.font.FontRenderContext;

/**
 * 
 * This class represents the Rock class and instantiates 
 * theMoveTrait to RockTraits as it is a Rock (via strategy
 * pattern).
 * 
 * @author Marcus
 *
 */
public class Rock extends MoveType{
	/**
	 * 
	 * @param position starting location of the MoveType
	 * @param inXVel x velocity
	 * @param inYVel y velocity
	 */
	public Rock(Point position, int inXVel, int inYVel) {
		this.position = position;
		xVel = inXVel;
		yVel = inYVel;
		
		theMoveTrait = new RockTraits();
		
	}
	/**
	 * @return the type of move.
	 */
	public TypesOfMoves getType() {
		return TypesOfMoves.ROCK;
	}
}
