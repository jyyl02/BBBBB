/**
 * Write a description of class BasicAnimation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import javafx.scene.input.KeyCode;
import javafx.animation.Animation;

public class BasicAnimation extends Application
{
    // private instance variables
    private Canvas canvas;
    private int screenWidth, screenHeight;
    
    public BasicAnimation()
    {
        // initialize instance variables
    }

    @Override 
    public void start(Stage stage) 
    {
        Canvas canvas = new Canvas(screenWidth, screenHeight);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run(gc)));
        tl.setCycleCount(Timeline.INDEFINITE);
        canvas.setFocusTraversable(true);

        // handle mouse and key events
        canvas.setOnKeyPressed(e ->
            {
                if(e.getCode() == KeyCode.W)
                {
                    // do something
                }
            });

        canvas.setOnMouseClicked(e -> 
            {
                // do something
            });

        stage.setTitle("Basic Animation");
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();
        tl.play();
    }

    private void run(GraphicsContext gc)
    {
        // color for background
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 500, 750);

        // objects on screen

    }

    // run program
    public static void main(String[] args)
    {
        Application.launch(args);
    }
}