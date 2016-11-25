   /**
 * Class BouncingBall - a graphical ball that observes the effect of gravity.  
 * 
 * @author: Bruce Quig
 * date: 13/09/1999
 */

import java.awt.*;
import java.awt.geom.*;

public class BouncingBall
{
    static final int gravity = 3;  // effect of gravity
    static final int ground = 400;       // y position of ground

    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color colour;
    private int diameter;
    int xPosition;
    int yPosition;
    int ySpeed = 1;  // downward speed

    /**
     * Constructor for objects of class BouncingBall
     */
    public BouncingBall(int xPos, int yPos, int ballDiameter, Color ballColour,
                        int groundPosition)
    {
        xPosition = xPos;
        yPosition = yPos;
        circle = new Ellipse2D.Double(xPos, yPos, ballDiameter, ballDiameter);
        colour = ballColour;
        diameter = (int)circle.getHeight();
        //ground = groundPosition;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw(Canvas canvas)
    {
        canvas.setForegroundColour(colour);
        canvas.fill(circle);
    }    


    /**
     * Erase this ball at its current position.
     **/
    public void erase(Canvas canvas)
    {
        canvas.erase(circle);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move(Canvas canvas)
    {
        // remove from canvas at the current position
        canvas.erase(circle);
            
        // compute new position
        ySpeed += gravity;
        yPosition += ySpeed;
        xPosition +=2;

        // check if it has hit the ground
        if(yPosition >= (ground - diameter) && ySpeed > 0)
        {
            yPosition = (int)(ground - diameter);
            ySpeed = -ySpeed + ballDegradation; 
        }
        circle.setFrame(xPosition, yPosition, diameter, diameter);

        // draw again at new position
        canvas.setForegroundColour(colour);
        canvas.fill(circle);
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }

}
