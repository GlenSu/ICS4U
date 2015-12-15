package su;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Time;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This is the beginning of a simple game. You should expand it into a dodgeball
 * game, where the user controls an object with the mouse or keyboard, and tries
 * to avoid the balls flying around the screen. If they get hit, it's game over.
 * If they survive for 20 seconds (or some other fixed time), they go on to the
 * next level. <br>
 * <br>
 * Should be run at around 500x300 pixels.<br>
 * <br>
 * @version Dec. 2015
 * 
 * @author Glen Su adapted from Sam Scott and Christina Kemp
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, MouseListener{
	
	/**
     * counts the number of clicks left
     **/
    static int mouseClicks = 3;
    /**
     * controls whether the player loses or not
     */
    boolean isPlaying = true;
    /**
     * the position at which the last mouse down event happened
     **/
    int playerX = getWidth() *-1;
	int playerY = getHeight() *-1;

	/**
	 * Radiuses of each circular polygon
	 */
    int radius;

    /**
     * The width and height of the Jpanel
     */
	int width = 700;
	int height = 500;

	/**
	 * The number of polygons on the screen that can be changed to the programmers discretion.
	 */
	static int numPolygons = 150;
	/**
	 * Stores the total amount of polygons
	 */
	static int remainingPolygons = numPolygons;
	
	/**
	 * The pause between repainting (should be set for about 30 frames per
	 * second).
	 */
	final int pauseDuration = 10;
	/**
	 * An array of polygons.
	 */
	FlashingBall[] ball = new FlashingBall[numPolygons];
	static RedCircle[] circle = new RedCircle[numPolygons];

	/** main program (entry point) */
	public static void main(String[] args) {

		// Set up main window (using Swing's Jframe)
		JFrame frame = new JFrame("Dodgeball");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500, 300));
		frame.setAutoRequestFocus(false);
		JOptionPane.showMessageDialog(frame, "To win this game, clear the game board of all polygons." + "\n" 
				+ "These polygons have an ability that upon being removed, will activate other polygons within the vicinity.", 
				"Welcome", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(frame, "Circular polygons will burst out upon being removed." + "\n" 
				+ "They will expand similar to an explosion from its core with a blast radius that, upon contant , "
				+ "can activate other other polygons.", "How to Play", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(frame, "Here's the catch. All the polygons must be removed within a set amount of 'activators.'" + "\n" 
				+ "By default, the total is set to " + mouseClicks + ".", "Careful", JOptionPane.WARNING_MESSAGE);
		frame.setVisible(true);
		frame.setLocation(300, 200);
		Container c = frame.getContentPane();
		c.add(new GamePanel());
		frame.pack();
		frame.setTitle("Polygonal Frenzy");
		frame.setResizable(false);
		
	}

	/**
	 * Constructor for the program that sets up the game
	 */
	public GamePanel(){
		// Start the ball bouncing (in its own thread)
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.WHITE);
		addMouseListener (this);
		for (int i = 0; i < numPolygons; i++) {
			int speedCap = 4;
			double sign = Math.random();
			int signX = 1;
			int signY = 1;
			if(sign >= 0.75){
				signX = -1;
				signY = -1;
			}
			else if(sign >= 0.5 && sign < 0.75){
				signX = 1;
				signY = -1;
			}
			else if(sign >= 0.25 && sign < 0.75){
				signX = -1;
				signY = 1;
			}
			else{
				signX = 1;
				signY = 1;
			}
			circle[i] = new RedCircle(10 + Math.random() * (width-(width/10)) ,10 + Math.random() * (height-(height/10)) , 0, width, 0, height);
			circle[i].setXSpeed((Math.random() * speedCap + 2) * signX);
			circle[i].setYSpeed((Math.random() * speedCap + 2) * signY);
			circle[i].setColor(new Color((int) (192), (int)  (96), (int) (96)));
			
		}
		
		Thread gameThread = new Thread(this);
		gameThread.start();

	}

	/**
	 * Repaints the frame periodically.
	 */
	public void run() {
		JFrame frame = new JFrame("Dodgeball");
		while (true) {
			try {
				Thread.sleep(pauseDuration);
			} catch (InterruptedException e) {
			}

			for (int i = 0; i < numPolygons; i++) {

				if(Math.sqrt(Math.pow(playerX-circle[i].getX(),2) + 
						Math.pow(playerY-circle[i].getY(),2)) <= circle[i].getRadius() &&  mouseClicks > 0 && mouseClicks <= 3 && !circle[i].isHit()){	 
					circle[i].hit();
					mouseClicks--;
					break;
				}
			}
			for(int i = 0; i < numPolygons; i++) {
				if(circle[i].isHit()){
					if(circle[i].isExpanding()){
						for(int j = 0; j < numPolygons; j++) {
							if(Math.sqrt(Math.pow(circle[j].getX()-circle[i].getX(),2) + 
									Math.pow(circle[j].getY()-circle[i].getY(),2)) <= circle[i].getRadius() + circle[j].getRadius()){
								circle[j].hit();
								
							}
						}
					}
				}
			}

			if(RedCircle.polygonsLeft() == 0){
				
				JOptionPane.showMessageDialog(frame, "You have won the game! The program will end after closing this message.",
						"Congratulations!!!", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			if(mouseClicks == 0){
				for(int i = 0; i < numPolygons; i++){
					if(circle[i].isHit()){
						isPlaying = false;
					}
				}

				if(isPlaying){
					JOptionPane.showMessageDialog(frame, "You have lost the game since you have ran out of activators and polygons are still active."
							+ " The program will end after closing this message.", "Try Again Next Time", JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
			}
			isPlaying = true;
			playerX = getWidth() *-1;
			playerY = getHeight() *-1;
			repaint();
		}
		for(int j = 0; j < numPolygons; j++) {
			circle[j].stopThread();
		}
		System.exit(0);
	}

	/**
	 * Clears the screen and paints the balls.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString ("Clicks: " + mouseClicks, 5, 20);
		g.drawString ("Polygons left: " + RedCircle.polygonsLeft(), 5, 40);
		for (int i = 0; i < numPolygons; i++) {
			//ball[i].draw(g);
			circle[i].draw(g);
			
//			if(Math.sqrt(Math.pow(playerX-circle[i].getX(),2) + 
//					Math.pow(playerY-circle[i].getY(),2)) <= circle[i].getRadius() &&  mouseClicks > 0 && mouseClicks <= 3){
//				
//				playerX = -2;
//				playerY = -2;
//			}
//			else{
//				System.out.println(playerX + " " + playerY);
//			}
		}

	}

	/**
	 * Gathers the x and y co-ordinates when the mouse is clicked
	 */
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		playerX = e.getX ();
		playerY = e.getY ();

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	/**
	 * Gathers the x and y co-ordinates when the mouse is released
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		playerX = e.getX ();
		playerY = e.getY ();
		repaint ();
	}

	/**
	 * sends the total amount of polygons left on the Jpanel
	 */
	public static int totalPolygons() {
		// TODO Auto-generated method stub
		return remainingPolygons;
	}
}
