/**
 * Write a description of class BasicAnimation here.
 * 
 * Joy Liu P5, Isabella Wu P6
 * @version (a version number or a date)
 */

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    
    private int gameState, levelNum;
    private int MENU, PLAYING, WON;
    
    public GameMain()
    {
        screenWidth = 750;
        screenHeight = 500;
        
        //** still need to figure out images
        //i = new ImageIcon("file");
        //gameBg = i.getImage();
        //Image gameFin = new Image("file");
        bigBoy = new BigBoy();
        menu = new Menu();
        
        MENU = 0;
        PLAYING = 1;
        WON = 2;
        gameState = MENU;
        levelNum = 0;
        level = new Level(levelNum);
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
                bigBoy.run(false);
            }
            
            if(e.getCode() == KeyCode.RIGHT)
            {
                bigBoy.run(true);
            }                       
        });
        
        canvas.setOnKeyReleased( e ->
        {
            if(e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.RIGHT)
            {
                bigBoy.setDx(0);
            }
            
            if(e.getCode() == KeyCode.UP)
            {
                bigBoy.jump();
            }
        });
        
        canvas.setOnMouseClicked(e ->
        {
            int mouseX = (int) e.getX();
            int mouseY = (int) e.getY();
            if(gameState == MENU)
            {
                //if mouse is clicked within the "START" button
                if(mouseX >= 450 && mouseX <= 300 
                && mouseY >= 300 && mouseY <= 225)
                {
                    gameState = PLAYING;
                    tl.play();
                    //test

                }                                   
            }
        });
        
        stage.setTitle("BBBBB");
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();
        tl.play(); 
    }

    private void run(GraphicsContext gc)
    {
        // color for background
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 750, 500);
        
        //test- not working!!
        //***** figures out images!
        //---File file = new File("file:src/bigboy-right.png");
        //Image image = new Image("c:\\bigboy-right.png");
        //gc.drawImage(image, 100, 100);
        
        // objects on screen        
         if(gameState == MENU)
        {
            menu.run(gc);
        }
        else if(gameState != WON)
        {
            //gc.drawImage(gameBg, 0, 0);
            //gc.drawImage(gameBg, -750, 0); ??????
            level.run(gc);
            gc.setFill(Color.WHITE);
            //score
            gc.fillText("" + bigBoy.getCherries() * 5, 200, 25);
            //cherry count (collected/total)
            gc.fillText(bigBoy.getCherries() + "/" + level.getCherries(), 125,
            25);
            //lives
            gc.fillText("" + bigBoy.getLives(), 25, 25);
        }
        else
        {
            //gc.drawImage(gameFin, 0, 0);
        }
    }
    
    // run program
    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
