/**
 * Write a description of class Level1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import java.io.*;
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

    /**
     * Constructor for objects of class Level1
     */
    public Level(int n)
    {
        //Canvas canvas = new Canvas(750, 500);
        //GraphicsContext gc = canvas.getGraphicsContext2D();
        
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
        for(int r = 0; r < mapHeight; r++)
         {            
             for(int c = 0; c < mapLength; c++)
             {
                int rc = map[r][c];
                
                if(rc == 1)
                {
                    //do a block 
                    //(x + c * tileSize, y + r * tileSize, tilesize, tilesize);
                }
             }
         }
    }
    
    public int getCherries()
    {
        return cherryNum;
    }
}
