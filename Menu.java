
/**
 * Write a description of class Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javafx.scene.image.Image;
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
        //background
        Image background = new Image("file:menuBg.png");
        gc.drawImage(background, 0, 0);
        //START button
        gc.setFill(Color.BLACK);
        gc.fillRect(300, 225, 150, 75);
        gc.setFill(Color.WHITE);
        gc.fillText("START GAME", 335, 265); //adjust values
        //names
        gc.fillText("Joy L\tIsabella W", 310, 400); //adjust values
        
        //test;
        Image image = new Image("file:bigboy-right.png");
        gc.drawImage(image, 100, 100);
    }
}
