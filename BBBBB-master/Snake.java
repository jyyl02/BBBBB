
/**
 * Write a description of class Snakes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javax.swing.ImageIcon;
import java.awt.Image;

public class Snake extends Sprite
{
    // instance variables
    private int dx;
    
    /**
     * Constructor for objects of class Snakes
     */
    public Snake(int x, int y, ImageIcon i)
    {
        super(x, y, i.getImage());
        dx = 1; //adjust value
    }
    
    //moves
    public void move()
    {
        setX(getX() + dx);
    }
    
    //change direction
    public void changeDirec()
    {
        
    }
    
    //alert + attack sequence
    public void attack()
    {
        
    }
    
    //dies when stepped on by bigboy
    public void die()
    {
        
    }
}
