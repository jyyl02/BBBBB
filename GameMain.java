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

public class GameMain extends Application
{
    // private instance variables
    private int screenWidth, screenHeight;
    private Menu menu;
    private Frame frame;
    private Level level;
    private BigBoy bigBoy;
    
    public GameMain()
    {
        screenWidth = 750;
        screenHeight = 500;
    }
    
    @Override 
    public void start(Stage stage) 
    {
        Canvas canvas = new Canvas(screenWidth, screenHeight);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run(gc)));
        tl.setCycleCount(Timeline.INDEFINITE);
        canvas.setFocusTraversable(true);

        
        //handle mouse and key events
        canvas.setOnKeyPressed( e ->
        {
            if(e.getCode() == KeyCode.LEFT)
            {
                BigBoy.run(false);
            }
            
            if(e.getCode() == KeyCode.RIGHT)
            {
                BigBoy.run(true);
            }
            
            if(e.getCode() == KeyCode.UP)
            {
                BigBoy.jump();
            }
        });
        
        canvas.setOnMouseClicked(e ->
        {
            if(tl.getStatus() == Animation.Status.PAUSED)
            {
                tl.play();
            }
            else
            {
                tl.pause();
            }
        });
        
        stage.setTitle("Game");
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
        gc.

    }

    // run program
    public static void main(String[] args)
    {
        Application.launch(args);
    }
}