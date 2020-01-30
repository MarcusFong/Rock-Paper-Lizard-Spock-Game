import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * 
 * This class is an abstract class that represents each type of move. This class
 * adapts the HFDP "Strategy" pattern by using the interface MoveTraits to
 * represent the different types of MoveTypes and how they differ from one and
 * another.
 * 
 * For example, if theMoveTrait is instantiated with the RockTraits class, the
 * text will always be size 20, Courier font, and in the color black.
 * 
 * @author Marcus
 *
 */
public abstract class MoveType {

	/**
	 * 
	 * @return the position of the MoveType as an object Point
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * 
	 * @return the x velocity of the MoveType as an int.
	 */
	public int getXVel() {
		return xVel;
	}

	/**
	 * 
	 * @return the y velocity of the MoveType as an int.
	 */
	public int getYVel() {
		return yVel;
	}

	/**
	 * Translates the move in the applet in the x direction by xVel and yVel in the
	 * y direction and changes theRect to fit the new coordinates of the rectangle
	 * (after it moves). 
	 */
	public void translate() {
		position.x += xVel;
		position.y += yVel;
		
		theRect.setRect(position.getX(), position.getY(), theRect.getWidth(), theRect.getHeight());
	}

	/**
	 * 
	 * @return the Font of the MoveType as an object Font. This method uses the
	 *         strategy pattern via the object theMoveTrait to return the specific
	 *         Font depending on what type of MoveType is instantiated (either Rock,
	 *         Paper, Scissor, etc.).
	 */
	public Font getFont() {
		return theMoveTrait.getFont();
	}

	/**
	 * 
	 * @return the Color of the MoveType as an object Color. This method uses the
	 *         strategy pattern via the object theMoveTrait to return the specific
	 *         color depending on what type of MoveType is instantiated (either
	 *         Rock, Paper, Scissor, etc.).
	 */
	public Color getColor() {
		return theMoveTrait.getColor();
	}

	/**
	 * 
	 * @return a Rectangle2D that represents the bounds of the MoveType in the
	 *         applet
	 */
	public Rectangle2D getRectangle() {
		return theRect;
	}

	/**
	 * 
	 * @param rect the Rectangle2D that is set to theRect which represents the
	 *             bounds of the move as a rectangle while it floats around in the
	 *             applet.
	 */
	public void setRectBounds(Rectangle2D rect) {
		theRect = rect;
	}

	
	/**
	 * 
	 * @param otherMove represents the other MoveType by the enum TypesOfMoves.
	 *                  otherMove is used to compare with this MoveType to see if
	 *                  this MoveType wins.
	 * @return true is this MoveType beats the other MoveType it just collided with
	 *         or false if it didn't.
	 */
	public boolean checkWin(TypesOfMoves otherMove) {
		TypesOfMoves[] strengths = this.getStrengths();

		for (int i = 0; i < strengths.length; i++) {
			if (otherMove.equals(strengths[i])) { // if the other move is beatable
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @return an array of TypesOfMoves that this particular instantiation of
	 *         MoveType can beat.
	 * 
	 *         This method uses the strategy pattern via the object theMoveTrait to
	 *         return the particular strengths of the MoveType object that is
	 *         instantiated (for example, if a Rock was instantiated, this array
	 *         would consist of [SCISSOR, LIZARD]).
	 */
	public TypesOfMoves[] getStrengths() {
		return theMoveTrait.getStrengths();
	}
	
	/**
	 * 
	 * @return an array of TypesOfMoves that this particular instantiation of
	 *         MoveType is weak to
	 * 
	 *         This method uses the strategy pattern via the object theMoveTrait to
	 *         return the particular weaknesses of the MoveType object that is
	 *         instantiated (for example, if a Rock was instantiated, this array
	 *         would consist of [PAPER, SPOCK]).
	 */
	public TypesOfMoves[] getWeaknesses() {
		return theMoveTrait.getWeaknesses();
	}


	public abstract TypesOfMoves getType();

	MoveTraits theMoveTrait;

	Point position;
	int xVel;
	int yVel;

	Rectangle2D theRect;

}
