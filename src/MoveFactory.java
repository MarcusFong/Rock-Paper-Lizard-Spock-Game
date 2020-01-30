import java.awt.Point;

/**
 * 
 * Because there are subclasses for each type of move,
 * rock, paper, scissors, etc., I decided to make a factory
 * class to simplify the instantiation process. This class 
 * uses the builder pattern to simplify the amount of parameters
 * the class has to process. 
 * 
 * @author Marcus
 *
 */
public class MoveFactory {

	private MoveFactory(MoveFactoryBuilder builder) {
		
		this.theMove = builder.getMoveString();
		this.xPos = builder.getXPos();
		this.yPos = builder.getYPos();
		this.xVel = builder.getXVel();
		this.yVel = builder.getYVel();
	}
	
	
	/**
	 * 
	 * Because there were a lot of variables to deal with,
	 * I decided to use the builder pattern to create factories 
	 * when creating moves.
	 * 
	 * @author Marcus
	 *
	 */
	public static class MoveFactoryBuilder {
		/**
		 * 
		 * @param theMove is the type of move ("ROCK",
		 * "PAPER", "SCISSOR", etc.)
		 */
		public MoveFactoryBuilder(String theMove) {
			this.theMove = theMove;
		}
		
		/**
		 * Instantiates the position of the MoveType.
		 * 
		 * @param xPos x starting position
		 * @param yPos y starting position
		 * @return MoveFactoryBuilder for builder pattern
		 */
		public MoveFactoryBuilder positionBuilder(int xPos, int yPos) {
			this.xPos = xPos;
			this.yPos = yPos;
			
			return this;
		}
		/**
		 * Instantiates the velocity of the MoveType.Move
		 * 
		 * @param xVel x velocity
		 * @param yVel y velocity
		 * @return MoveFactoryBuilder for builder pattern
		 */
		public MoveFactoryBuilder velocityBuilder(int xVel, int yVel) {
			this.xVel = xVel;
			this.yVel = yVel;
			
			return this;
		}
		
		/**
		 * 
		 * @return a MoveFactory object to create a specific
		 * type of MoveFactor. 
		 */
		public MoveFactory done() {
			return new MoveFactory(this);
		}
		
		/**
		 * 
		 * @return the String name of the move. e.g
		 * "ROCK" or "PAPER" or "SCISSOR" etc. 
		 */
		public String getMoveString() {
			return theMove;
		}
		
		/**
		 * 
		 * @return the position of the Mo in the
		 * x direction
		 */
		public int getXPos() {
			return xPos;
		}
		/**
		 * 
		 * @return the position of the MoveType in the
		 * y direction
		 */
		public int getYPos() {
			return yPos;
		}
		
		/**
		 * 
		 * @return the velocity of the MoveType in the
		 * x direction
		 */
		public int getXVel() {
			return xVel;
		}
		
		/**
		 * 
		 * @return the velocity of the MoveType in the 
		 * y direction
		 */
		public int getYVel() {
			return yVel;
		}		
		
		private String theMove; 
			
		private int xPos;
		private int yPos;
		
		private int xVel;
		private int yVel;	
	}
	
	
	/**
	 * 
	 * @return a MoveType that is either a Rock, Paper, 
	 * Scissor, etc.
	 */
	public MoveType createMove() {
		Point location = new Point(xPos, yPos);
		
		switch(theMove) {
		
		case "ROCK":
			return new Rock(location, xVel, yVel); 
		case "PAPER":
			return new Paper(location, xVel, yVel); 

		case "SCISSOR":
			return new Scissor(location, xVel, yVel); 

		case "LIZARD":
			return new Lizard(location, xVel, yVel); 
		case "SPOCK":
			return new Spock(location, xVel, yVel); 
		case "DEATHSTAR":
			return new DeathStar(location);
		default:
			return null;
		}
		
		
	}
	
	private String theMove; 
	
	private int xPos;
	private int yPos;
	
	private int xVel;
	private int yVel;	
}
