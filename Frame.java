/**
 * Write a description of class Level1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Level
{
    // instance variables
    private int width, height;

    /**
     * Constructor for objects of class Level1
     */
    public Level(int width, int height)
    {
        this.width = width;
        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();
    }
}
