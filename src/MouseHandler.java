import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 
 * This is a helper class that handles all of the mouse listening
 * events and methods. I only use mouseClicked() so the rest of the
 * methods are empty.
 *
 * @author Marcus
 *
 */
public class MouseHandler implements MouseListener {

	/**
	 * Creates a new DeathStar every time there is a click on the screen
	 * it is clicked. 
	 */
	public void mouseClicked(MouseEvent e) {
		System.out.println("ASD");
		int xCor = e.getX();
		int yCor = e.getY();
		clickLocation = new Point(xCor, yCor);
		
		Playground.createDeathStar(clickLocation);
	}

	public void mousePressed(MouseEvent e) {

		
	}

	public void mouseReleased(MouseEvent e) {		
	}

	public void mouseEntered(MouseEvent e) {		
	}

	public void mouseExited(MouseEvent e) {		
	}
	
	public 
	
	Point clickLocation;

}
