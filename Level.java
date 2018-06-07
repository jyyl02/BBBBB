
/**
 * Write a description of class Level1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import java.io.*;
import javafx.scene.image.Image;
import java.awt.*;

public class Level
{
    // instance variables
    private int x, y;
    private String lvl;
    private int cherryNum;
    private int tileSize;
    private int[][] map;
    private int mapLength, mapHeight;
    
    private Image bG;
    private Image block;
    private Image cherry;
    private Image goal;

    /**
     * Constructor for objects of class Level1
     */
    public Level(int n)
    {   
        if(n == 0)
        {
            lvl = "tutorial.txt";
        }
        else if(n == 1)
        {
            lvl = "level1.txt";
        }
        else if(n == 2)
        {
            lvl = "level2.txt";
        }
        else if(n == 3)
        {
            lvl = "level3.txt";
        }
        
        
        try
        {
             BufferedReader br = new BufferedReader(new FileReader(lvl));
             
             tileSize = 60;
             mapHeight = 12; //?
             mapLength = Integer.parseInt(br.readLine());
             cherryNum = Integer.parseInt(br.readLine());
             map = new int[mapHeight][mapLength];
             
             String delimiters = " ";
             for(int r = 0; r < mapHeight; r++)
             {
                 String line = br.readLine();
                 String[] tokens = line.split(delimiters);
                 
                 for(int c = 0; c < mapLength; c++)
                 {
                    map[r][c] = Integer.parseInt(tokens[c]);
                 }
             }
        }
        catch(Exception e) {}
    }
    
    public void run(GraphicsContext gc)
    {        
        bG = new Image("gameBg.png");
        gc.drawImage(bG, 0, 0);
        block = new Image("block.png");
        cherry = new Image("block.png");
        goal = new Image("block.png");
        
        for(int r = 0; r < mapHeight; r++)
         {            
             for(int c = 0; c < mapLength; c++)
             {
                int rc = map[r][c];
                
                if(rc == 1)
                {
                    //do a block
                    gc.drawImage(block, x + c * 60, y + r * 60);
                }
                if(rc == 2)
                {
                    //do a cherry 
                    gc.drawImage(cherry, x + c * 60, y + r * 60);
                }
                if(rc == 3)
                {
                    //do a goal 
                    gc.drawImage(goal, x + c * 60, y + r * 60);
                }
             }
         }
    }
    
    public int getYPos(int y)
    {
        return y / tileSize;
    }
    
    public int getXPos(int x)
    {
        return x / tileSize;
    }
    
    public int getTile(int r, int c)
    {
        return map[r][c];
    }
    
    public int getTileSize()
    {
        return tileSize;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public void setX(int n)
    {
        x = n;
    }
    
    public void setY(int n)
    {
        x = n;
    }
    
    public int getCherries()
    {
        return cherryNum;
    }
}
