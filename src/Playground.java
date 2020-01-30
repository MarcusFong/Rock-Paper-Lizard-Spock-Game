import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.Timer;

/**
 * 
 * VIDEO DEMONSTRATION: https://youtu.be/A2EcuJEfD1s
 * 
 * Due to some problems with my Eclipse, please note that while testing this 
 * program, I was only able to run it on Java 7 – Java 8 wasn't working for 
 * some reason. I also use the "Run Parameters" function to simulate an HTML
 * file. See below screenshots to see what parameters I used. 
 * 
 * This is the RPSLK Warfare game by Marcus Fong with the "Death Star" addition!
 * 
 * Playground.java is the main class that runs the applet and controls the
 * majority of the program of this game. It starts of by using the "fake HTML"
 * file (via Eclipse's "Run Preferences function") as reference to create the
 * initial MoveTypes (the Strings that float around in the applet) based on what
 * was specified. The parameters only specify the number of MoveTypes to build,
 * which types of MoveTypes to build, their respective locations, and their
 * speeds – the rest of the parameters for each MoveType (e.g font size or font
 * type) are stored as constants via the strategy pattern. See below for the
 * specific parameters I used to test this file.
 * 
 * An ArrayList called theMoves stores the MoveTypes that are in the system and
 * the program calls various functions on them to run the game. This ranges from
 * .translate() (to move the MoveTypes across the screen) to checkWin() (to
 * calculate the surviving object after a collision in the applet.)
 * 
 * With a delay specified in the HTML, there is an ActionListener that continuously
 * updates and runs the game. processTheMoves() and repaint() are the two main methods
 * that keep the game running.
 * 
 * Click on the screen to place a Death Star. It will destroy anything it encounters.
 * I wanted to have a little fun with my last 1007 assignment so I decided to use
 * an actual image of a Death Star to represent each Death Star. Below is the link to
 * the image: https://www.shopdisney.com/death-star-pop-up-picnic-blanket-and-bag-star-wars-099967447607.html
 * 
 * Parts of this class have been borrowed by Professor Kender's uploaded example
 * of Playground.java.
 * 
 * HTML PARAMETERS:
 * (The list of parameters I used in the screen shots below were the ones I used when
 * I tested my program. It creates 5 different MoveTypes that float around at different
 * speeds and start at different places. See below for a reference/key to how I named my 
 * parameters.)
 *  
 * List of parameters image 1: https://imgur.com/a/yUnMZy6
 * List of parameters image 2: https://imgur.com/a/zysRMsy
 * 
 * HTML Parameter Formatting Reference/Key Table:
 * 
 * delay: delay for the ActionListener
 * numOfMoves: the initial number of moves to be processed
 * 
 * i = the i'th MoveType to be created
 * 
 * move[i]: the type of MoveType to be created (e.g ROCK)
 * move[i]X: the starting x coordinate of the particular move
 * move[i]Y: the starting Y coordinate of the particular move
 * move[i]XVel: the x velocity of the particular move
 * move[i]YVel: the  y velocity  of the particular move
 * 
 * 
 * @author Marcus
 * 
 * 
 *
 */
public class Playground extends Applet {

	/**
	 * This method is called when the applet is created. It initializes
	 * all of the MoveTypes and other variables and sets up the 
	 * ActionListener to run the game. 
	 */
	public void init() {
		theMoves = new ArrayList<MoveType>();
		initHTMLMoves();
		
		DEATH_STAR_PIC = getImage(getDocumentBase(), "DEATH_STAR.png");
		
		htmlDelay = Integer.parseInt(getParameter("delay"));
		
		addMouseListener(new MouseHandler());
		appletTimer = new Timer(htmlDelay, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				processTheMoves();
				repaint();
			}
		});
	}

	/**
	 * This method initializes all the specified MoveTypes in the "fake HTML" via
	 * the Eclipse run parameters function and adds them to the ArrayList theMoves.
	 */
	private void initHTMLMoves() {
		int numOfMoves = Integer.parseInt(getParameter("numOfMoves"));
		Graphics2D g2D = (Graphics2D) getGraphics();
		FontRenderContext throwContext = g2D.getFontRenderContext();

		for (int i = 0; i < numOfMoves; i++) {
			String moveNum = "move" + i;

			String moveName = getParameter(moveNum);

			int xPos = Integer.parseInt(getParameter(moveNum + "X"));
			int yPos = Integer.parseInt(getParameter(moveNum + "Y"));

			int xVel = Integer.parseInt(getParameter(moveNum + "XVel"));
			int yVel = Integer.parseInt(getParameter(moveNum + "YVel"));
			System.out.println(xPos + yPos + xVel + yVel);

			moveFactory = new MoveFactory
					.MoveFactoryBuilder(moveName)
					.positionBuilder(xPos, yPos)
					.velocityBuilder(xVel, yVel)
					.done();

			MoveType theMove = moveFactory.createMove();

			// setting a rectangle that is associated with the move that
			// floats around
			theMove.setRectBounds(theMove.getFont().getStringBounds(theMove.getType().toString(), throwContext));

			theMoves.add(theMove);
		}
	}

	/**
	 * This method translates each move in their respective x and y values and
	 * checks for collision. Collisions and their location are calculated with
	 * respect to the Rectangle2D that is drawn with the MoveType that floats around
	 * in the applet.
	 */
	public void processTheMoves() {
		for (int i = 0; i < theMoves.size(); i++) {
			MoveType theMove = theMoves.get(i);
			theMove.translate();

			if (checkAlive(theMove, i)) {
				Rectangle2D moveBounds = theMove.getRectangle();
				Point location = theMove.getPosition();

				checkLoopAround(moveBounds, location);
			}
		}
	}

	/**
	 * 
	 * This method checks if theMove collided with something(via
	 * Rectangle2D.intersects), and if it did, it calculates which MoveType prevails
	 * in the collision.
	 * 
	 * @param theMove  is the MoveType to check if it has collided with anything.
	 * @param theIndex is the index of theMove in the ArrayList theMoves
	 * @return true if the move survives the collision with the other move and false
	 *         if it does not.
	 */
	public boolean checkAlive(MoveType theMove, int theIndex) {
		for (int i = 0; i < theMoves.size(); i++) {
			MoveType otherMove = theMoves.get(i);
			Rectangle2D theRect = theMove.getRectangle();
			Rectangle2D otherRect = otherMove.getRectangle();

			if (!otherMove.getType().equals(theMove.getType()) && theRect.intersects(otherRect)) {

				if (theMove.checkWin(otherMove.getType())) {
					theMoves.remove(i); // remove the MoveType theMove collided w/ b/c it lost
					return true;
				}
				theMoves.remove(theIndex); // remove theMove b/c it lost
				return false;
			}
		}
		return true; // no collision – is still alive
	}

	/**
	 * 
	 * This method checks if the the current MoveType that is being processed is out
	 * of bounds of the applet. If the entire body of the MoveType moves ouf of
	 * bounds, this method teleports it to the opposite side from where it came from
	 * in the applet.
	 * 
	 * @param moveBounds the rectangular bounds of the move that is floating around
	 * @param location   the location of the move as a Point object
	 */
	public void checkLoopAround(Rectangle2D moveBounds, Point location) {
		// code to wrap the move around the other side if it goes
		// out of bounds
		if (location.getX() + moveBounds.getWidth() < 0)
			location.x = getWidth();
		else if (location.getY() + moveBounds.getHeight() <= 0) {
			location.y = getHeight() + (int) moveBounds.getHeight();
		} else if (location.getX() >= getWidth()) {
			location.x = (int) -moveBounds.getWidth();
		} else if (location.getY() - moveBounds.getHeight() >= getHeight()) {
			location.y = 0;
		}
	}
	
	/**
	 * This method is called to create a DeathStar whenever a mouse is clicked.
	 * This method adds a new DeathStar to theMoves so it will be able to be 
	 * processed.
	 * @param location of the mouse click as a Point object. 
	 */
	public static void createDeathStar(Point location) {
		moveFactory = new MoveFactory
				.MoveFactoryBuilder("DEATHSTAR")
				.positionBuilder((int)location.getX(), (int)location.getY())
				.velocityBuilder(0, 0)
				.done();
		
		MoveType theDeathStar = moveFactory.createMove();
		theDeathStar.setRectBounds
			(new Rectangle((int)location.getX(), (int)location.getY(), 45, 45));

		theMoves.add(theDeathStar);
	}
	
	
	
	
	/**
	 * Starts the applet and its timer
	 */
	public void start() {
		appletTimer.start();
	}
	/**
	 * Paints the applet with all the alive MoveTypes in theMoves.
	 */
	public void paint(Graphics g) {
		for (MoveType theMove : theMoves) {
			if (theMove.getType().equals(TypesOfMoves.DEATHSTAR)) {
				g.drawImage(DEATH_STAR_PIC, theMove.getPosition().x, theMove.getPosition().y ,this);
			}
			else {
				g.setFont(theMove.getFont());
				g.setColor(theMove.getColor());
				g.drawString(theMove.getType().toString(), theMove.getPosition().x, theMove.getPosition().y);
			}
		}
	}
	/**
	 * Stops the program.
	 */
	public void stop() {
		appletTimer.stop();
	}

	public void destroy() {
	}

	private static ArrayList<MoveType> theMoves;
	private static MoveFactory moveFactory;
	private static Image DEATH_STAR_PIC;

	private int htmlDelay;
	private Timer appletTimer;
	

}
