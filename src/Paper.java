import java.awt.Point;
/**
 * 
 * This class represents the Paper class and instantiates 
 * theMoveTrait to PaperTraits as it is a Paper (via strategy
 * pattern).
 * 
 * @author Marcus
 *
 */
public class Paper extends MoveType {

	/**
	 * 
	 * @param position starting location of the MoveType
	 * @param inXVel x velocity
	 * @param inYVel y velocity
	 */
	public Paper(Point position, int inXVel, int inYVel) {
		this.position = position;
		xVel = inXVel;
		yVel = inYVel;
		
		theMoveTrait = new PaperTraits();
	}
	/**
	 * @return the type of move.
	 */
	public TypesOfMoves getType() {
		return TypesOfMoves.PAPER;
	}
}
