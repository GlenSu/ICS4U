/**
 * 
 */
package su;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Glen Su
 *	Dec 05 2015
 */
public class RedCircle extends MovingObject {
	/**
     * the position at which the last mouse down event happened
     **/
    int playerX = -1, playerY = -1;
    /**
     * counts the number of clicks so far
     **/
    int mouseClicks = 3;
    /**
	 * The counter that keeps track of how many polygons are left
	 */
	static int polygonsLeft = GamePanel.totalPolygons();
    
    private static int radiusSetter = 10;
	private int radius;
	private int counter;
	private boolean isHit;
	private boolean isExpanding;
	/**
	 * @param x
	 * @param y
	 * @param left
	 * @param right
	 * @param top
	 * @param bottom
	 */
	public RedCircle(double x, double y, int left, int right, int top, int bottom) {
		super(x, y, left + radiusSetter, right - radiusSetter, top + radiusSetter, bottom - radiusSetter);
		// TODO Auto-generated constructor stub
		this.setRadius(radiusSetter);
		isHit = false;
		isExpanding = false;
	}

	/* (non-Javadoc)
	 * @see su.MovingObject#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		int drawX = (int) getX() - (radius);
		int drawY = (int) getY() - (radius);
		
		g.setColor(color);
		g.drawOval(drawX ,drawY, getRadius()*2, getRadius()*2);
		g.fillOval(drawX, drawY, radius * 2, radius * 2);
	}

	/* (non-Javadoc)
	 * @see su.MovingObject#animateOneStep()
	 */
	@Override
	public void animateOneStep() {
		// TODO Auto-generated method stub
		double waitTime = Math.random() * 7;
		if(isHit){
			counter++;
			if(counter <= 60 && counter > waitTime + 43){
				expanding();
				if(counter % 1 == 0){
					radius+=4;
				}
			}
			else if(counter <= 50){
				
			}
			else{
				radius = 0;
				this.setX(-50);
				this.setY(-50);
				if(polygonsLeft > 0){
					polygonsLeft--;
				}
				this.isHit = false;
				this.isExpanding = false;
				
			}
		}
	}
	
	/**
	 * Returns the number of polygons left on the Jpanel
	 * @return polygonsLeft - polygons left
	 */
	public static int polygonsLeft(){
		return polygonsLeft;
	}
	
	/**
	 * Returns the radius of a circle in RedCircle
	 * @return radius - the radius of a circle
	 */
	public int getRadius() {
		return radius;
	}
	
	/**
	 * Sets the radius of a circle in RedCircle
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	/**
	 * Returns true if a circle in RedCircle is expanding
	 * @return isExpanding - true if expanding
	 */
	public boolean isExpanding(){
		return isExpanding;
		
	}
	
	/**
	 * Sets a boolean variable to true if a circle in RedCircle is expanding
	 */
	public void expanding() {
		this.isExpanding = true;
	}
	
	/**
	 * Returns true if a circle in RedCircle is hit
	 * @return isHit - true if hit
	 */
	public boolean isHit() {
		return isHit;
	}
	
	/**
	 * Makes a  circle in RedCircle stop and turn light grey if hit
	 */
	public void hit() {
		this.isHit = true;
		this.setXSpeed(0);
		this.setYSpeed(0);
		this.setColor(Color.LIGHT_GRAY);
	}

}
