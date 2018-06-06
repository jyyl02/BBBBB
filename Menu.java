
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
    public void run(GraphicsContext gc)
    {
        // color for background
        gc.setFill(Color.RED);
        gc.fillRect(0, 0, 750, 500);
        //START button
        gc.setFill(Color.BLACK);
        gc.fillRect(300, 225, 150, 75);
        gc.setFill(Color.WHITE);
        gc.fillText("START GAME", 335, 265); //adjust values
        //credits
        gc.fillText("Joy L\tIsabella W", 310, 400); //adjust values
    }
}
