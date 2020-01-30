import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

/**
 * 
 * This class represents the DeathStar class and instantiates 
 * theMoveTrait to DeathStarTraits as it is a DeathStar (via strategy
 * pattern). I decided to make a DeathStar type MoveType to make 
 * my program more flexible – even though a DeathStar isn't really a
 * "move". The only difference is that it doesn't move.
 * 
 * @author Marcus
 *
 */
public class DeathStar extends MoveType{
	
	/**
	 * 
	 * @param position starting location of the MoveType
	 * @param inXVel x velocity
	 * @param inYVel y velocity
	 */
	public DeathStar(Point position) {
		this.position = position;
		xVel = 0;
		yVel = 0;
		
		theMoveTrait = new DeathStarTraits();
	}
	
	/**
	 * @return the type of move.
	 */
	public TypesOfMoves getType() {
		// TODO Auto-generated method stub
		return TypesOfMoves.DEATHSTAR;
	}
}
