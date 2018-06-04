
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
    public Menu()
    {
        
    }
    
    private void run(GraphicsContext gc)
    {
        // color for background
        gc.setFill(Color.RED);
        gc.fillRect(0, 0, 750, 500);
        //START button
        gc.fillRect(750 / 3, 500 / 2, 150, 75);
        gc.fillText("START GAME", 750 / 2, 500 / 2); //adjust values
        //credits
        gc.fillText("Joy L\tIsabella W", 750 / 2, 2 * 500 / 3); //adjust values
    }
}
