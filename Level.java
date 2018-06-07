/**
 * Write a description of class Level1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import java.io.*;
import javafx.scene.image.Image;
import java.awt.*;
import javafx.scene.paint.Color;

public class Level
{
    // instance variables
    private int x, y;
    private String lvl;
    private int cherryNum;
    private int tileSize;
    private int[][] map;
    private int mapLength, mapHeight;
    
    private Image block;
    private Image cherry;

    /**
     * Constructor for objects of class Level1
     */
    public Level(int n)
    {  
        x = 0;
        y = 0;
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
            Scanner inFile = new Scanner(new File("level1.txt")); 

            int count = 0;
            int row = 0;

            int tileSize = 60;
            int mapHeight = 12; //?
            int mapLength = 0;
            int cherryNum = 0;

            while(inFile.hasNext())
            {
                if(count == 0)
                {
                    mapLength = inFile.nextInt();
                    map = new int[mapHeight][mapLength];
                }
                else if(count == 1)
                {
                    cherryNum = inFile.nextInt();
                }
                else
                {
                    String line = inFile.nextLine();

                    if(!line.equals(""))
                    {
                        String[] tokens = line.split(" ");

                        for(int i = 0; i < tokens.length; i++)
                        {
                            map[row][i] = Integer.parseInt(tokens[i]);
                        }

                        row++;
                    }
                }

                count++;
            }
            inFile.close();

            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void run(GraphicsContext gc)
    {        
        block = new Image("file:block.png");
        cherry = new Image("file:block.png");
        
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
                    gc.setFill(Color.WHITE);
                    gc.fillRect(x + c * 60, y + r * 60, 60, 60);
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
