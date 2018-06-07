
 * Write a description of class BasicAnimation here.
 * 
 * Joy Liu P5, Isabella Wu P6
 * @version (a version number or a date)
 */

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;
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
    private int MENU, PLAYING, PAUSED, WON;
    
    public GameMain()
    {
        screenWidth = 750;
        screenHeight = 500;
        
        //** still need to figure out images
        //ImageIcon i = newImageIcon("file");
        //menuBg = i.getImage();
        //i = new ImageIcon("file");
        //gameBg = i.getImage();
        bigBoy = new BigBoy();
        menu = new Menu();
        
        MENU = 0;
        PLAYING = 1;
        PAUSED = 2;
        WON = 3;
        gameState = MENU;
        levelNum = 0; 
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
            
            if(e.getCode() == KeyCode.UP)
            {
                bigBoy.jump();
            }
        });
        
        canvas.setOnKeyReleased( e ->
        {
            if(e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.RIGHT)        
                bigBoy.setDx(0);
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
                    System.out.print("ooo");
                }
                                    
            }
            
            if(gameState == PAUSED)
            {
                tl.play();
                gameState = PLAYING;
            }
            else if(gameState == PLAYING)
            {
                tl.pause();
                gameState = PAUSED;
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
        
        //test- not working
        //***** figures out images!
        //---File file = new File("file:src/bigboy-right.png");
        //Image image = new Image("c:\\bigboy-right.png");
        //gc.drawImage(image, 100, 100);
        
        // objects on screen
        
         if(gameState == MENU)
        {
            //gc.drawImage(menuBg, 0, 0);
            menu.run(gc);
        }
        else if(gameState != WON)
        {
            //gc.drawImage(gameBg, 0, 0);
            //gc.drawImage(gameBg, -750, 0); ??????
            gc.setFill(Color.WHITE);
            //score
            gc.fillText("" + bigBoy.getCherries() * 5, 200, 25);
            //cherry count (collected/total)
            gc.fillText(bigBoy.getCherries() + "/" + level.getCherries(), 125,
            25);
            //lives
            gc.fillText("" + bigBoy.getLives(), 25, 25);
        }
        
       
        /*test
        gc.setFill(Color.WHITE);
        gc.fillText("Score: 15", 200, 25); //score
        gc.fillText("0 / 3", 125, //cherry count
            25);
        gc.fillText("3 / 3 lives", 25, 25); //lives
        */
    }
    

    // run program
    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
