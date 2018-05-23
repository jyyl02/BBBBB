
/**
 * Write a description of class Sprite here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Sprite
{
    //instance variables
    private int x, y; //x and y location
    private int width, height; //size
    private Image image;
    
    /**
     * Constructor for objects of class Sprite
     */
    public Sprite(int x, int y, Image image)
    {
        this.x = x;
        this.y = y;
        this.image = image;
        width = this.image.getWidth(null);
        height = this.image.getHeight(null);
    }

    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }  
    
    public int getHeight()
    {
        return height;
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public Image getImage()
    {
        return image;
    }
    
    public void setX(int s)
    {
        x = s;
    }
    
    public void setY(int s)
    {
        y = s;
    }
}
