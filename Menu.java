
/**
 * Write a description of class Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Menu
{
    // instance variables
    private int height, width;
    /**
     * Constructor for objects of class Menu
     */
    public Menu()
    {

    }
    
    public void start(Stage stage)
    {
        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        stage.setTitle("Start");
    }
}
