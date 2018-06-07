/**
 * Write a description of class GameMain here.
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
    private Level level;
    private BigBoy bigBoy;
    private Image gameBg, gameFin;
    
    private int gameState, levelNum;
    private int MENU, PLAYING, WON;
    
    public GameMain()
    {
        screenWidth = 750;
        screenHeight = 500;
        
        //** still need to figure out images
        gameBg = new Image("file:gameBg.png");
        gameFin = new Image("file:gameFin.png");
        bigBoy = new BigBoy(level);
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
                bigBoy.setLeft(true);
            }
            
            if(e.getCode() == KeyCode.RIGHT)
            {
                bigBoy.setRight(true);
            }
            
            if(e.getCode() == KeyCode.UP)
            {
                bigBoy.setJumping(true);
            }
        });
        
        canvas.setOnKeyReleased( e ->
        {
            if(e.getCode() == KeyCode.LEFT)
            {
                bigBoy.setLeft(false);
            }
            
            if(e.getCode() == KeyCode.RIGHT)
            {
                bigBoy.setRight(false);
            } 
        });
        
        canvas.setOnMouseClicked(e ->
        {
            int mouseX = (int) e.getX();
            int mouseY = (int) e.getY();
            if(gameState == MENU)
            {
                //if mouse is clicked within the "START" button
                //if(mouseX >= 450 && mouseX <= 300 
                //&& mouseY >= 300 && mouseY <= 225)
                //{
                    //gameState = PLAYING;
                    //tl.play();
                    //test
                //}  
                
                gameState = PLAYING;
                tl.play();
            }
        });
        
        stage.setTitle("BBBBB");
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();
        tl.play(); 
    }

    private void run(GraphicsContext gc)
    {
        //test- not working!!
        //***** figures out images!
        //---File file = new File("file:src/bigboy-right.png");
        //Image image = new Image("file:bigboy-right.png");
        //gc.drawImage(image, 100, 100);
        
        // objects on screen        
         if(gameState == MENU)
        {
            menu.run(gc);
        }
        else if(gameState != WON)
        {
            gc.drawImage(gameBg, 0, 0);
            //gc.drawImage(gameBg, -750, 0); ??????
            gc.setFill(Color.WHITE);
            //score, cherries, lives
            gc.fillText("score:" + bigBoy.getCherries() * 5 + "\t" 
            + bigBoy.getCherries() + "/" + level.getCherries() + " cherries"
            + "\tlives: " + bigBoy.getLives(), 25, 25);
            
            level.run(gc);
            bigBoy.run(gc);
        }
        else
        {
            gc.drawImage(gameFin, 0, 0);
        }
    }
    
    // run program
    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
