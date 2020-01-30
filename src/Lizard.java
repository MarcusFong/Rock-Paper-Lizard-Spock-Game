import java.awt.Point;

/**
 * 
 * This class represents the Lizard class and instantiates 
 * theMoveTrait to LizardTraits as it is a Lizard (via strategy
 * pattern).
 * 
 * @author Marcus
 *
 */

public class Lizard extends MoveType{
	/**
	 * 
	 * @param position starting location of the MoveType
	 * @param inXVel x velocity
	 * @param inYVel y velocity
	 */
	public Lizard(Point position, int inXVel, int inYVel) {
		this.position = position;
		xVel = inXVel;
		yVel = inYVel;
		
		theMoveTrait = new LizardTraits();
	}
	
	/**
	 * @return the type of move.
	 */
	public TypesOfMoves getType() {
		return TypesOfMoves.LIZARD;
	}
}
