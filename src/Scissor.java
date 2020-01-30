import java.awt.Point;
/**
 * 
 * This class represents the Scissor class and instantiates 
 * theMoveTrait to ScissorTraits as it is a Rock (via strategy
 * pattern).
 * 
 * @author Marcus
 *
 */ 


public class Scissor extends MoveType{

	/**
	 * 
	 * @param position starting location of the MoveType
	 * @param inXVel x velocity
	 * @param inYVel y velocity
	 */
	public Scissor(Point position, int inXVel, int inYVel) {
		this.position = position;
		xVel = inXVel;
		yVel = inYVel;
		
		theMoveTrait = new ScissorTraits();
	}
	
	/**
	 * @return the type of move.
	 */
	public TypesOfMoves getType() {
		return TypesOfMoves.SCISSOR;
	}
}
