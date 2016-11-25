/**
 * Class Tester - provides some methods that demonstrate some of the 
 * capabilities of the Canvas class. 
 * 
 * @author: Bruce Quig
 * date: 13/09/1999
 */

import java.awt.*;
import java.awt.geom.*;

public class Tester   
{
    // canvas object
    private Canvas myCanvas;

    /**
     * Constructor for objects of class Tester
     */
    public Tester()
    {
        // initialise instance variables
        myCanvas = new Canvas("Testing Canvas Class", 600, 500);
        myCanvas.setVisible(true);
    }
 
   /**
    * test method for testing Canvas class
    * Moves a Rectangle object around the screen in a rectangular
    * direction.  It changes colour each time.
    * 
    * @param x the initial x axis position of the shape
    * @param y the initial x axis position of the shape
    * @param xTravel the length of x axis travel
    * @param yTravel the length of x axis travel
    * @param iterations the number of cycles to perform
    * 
    */
    public void testSquare(int x, int y, int xTravel, int yTravel, int iterations)
    {
        int stringX = 20;
        int stringY = 30 + y + yTravel;
        
        // colours to rotate between
        Color[] rainbow = 
            {Color.red, Color.gray, Color.blue, Color.green, Color.black}; 
        String[] colourNames = {"red", "gray", "blue", "green", "black"}; 
        
        // the shape to draw and move     
        Rectangle rect = new Rectangle(x, y, 10, 10);
        int distance = (xTravel * 2) + (yTravel * 2);
        myCanvas.setFont(new Font("helvetica", Font.BOLD, 14));
        for(int count = 0; count < iterations; count++)
        {
            myCanvas.setForegroundColour(rainbow[count % rainbow.length]);
            myCanvas.drawString(colourNames[count % rainbow.length], stringX, stringY);
            for(int i = 0; i < distance; i ++)
            {
                myCanvas.fill(rect);
                myCanvas.wait(10);

                // travel east
                if(i < xTravel)
                {
                    myCanvas.erase(rect);
                    rect.setLocation(x++, y);
                }
                // travel south
                else if(i < (xTravel + yTravel))
                {
                    myCanvas.erase(rect);
                    rect.setLocation(x, y++);
                }
                // travel west
                else if(i < ((xTravel * 2) + yTravel))
                {
                    myCanvas.erase(rect);
                    rect.setLocation(x--, y);
                }
                // travel north        
                else if (i < distance)
                {
                    myCanvas.erase(rect);
                    rect.setLocation(x, y--);
                }
            }
            myCanvas.eraseString(colourNames[count % rainbow.length], stringX, stringY);
        }
    }

    /**
     * simulates a bouncing ball
     * 
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.blue, ground);
        ball.draw(myCanvas);
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.red, ground);
        ball2.draw(myCanvas);

        boolean finished =  false;
        while(!finished)
        {
            myCanvas.wait(50);           // small delay
            ball.move(myCanvas);
            ball2.move(myCanvas);
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() == 550 && ball.getXPosition() == 550)
                finished = true;
        }
        ball.erase(myCanvas);
        ball2.erase(myCanvas);
    }
}
