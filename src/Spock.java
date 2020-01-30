import java.awt.Point;

/**
 * 
 * This class represents the Spock class and instantiates 
 * theMoveTrait to SpockTraits as it is a Spock (via strategy
 * pattern).
 * 
 * @author Marcus
 *
 */
public class Spock extends MoveType{
	/**
	 * 
	 * @param position starting location of the MoveType
	 * @param inXVel x velocity
	 * @param inYVel y velocity
	 */
	public Spock(Point position, int inXVel, int inYVel) {
		this.position = position;
		xVel = inXVel;
		yVel = inYVel;
		
		theMoveTrait = new SpockTraits();
	}
	
	/**
	 * @return the type of move.
	 */
	public TypesOfMoves getType() {
		return TypesOfMoves.SPOCK;
	}
}
