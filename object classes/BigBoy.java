/**
 * Write a description of class BigBoy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class BigBoy extends Sprite
{
    //instance variables
    private int lives, cherries; //unique variables
    private int dx, dy;
    
    /**
     * Constructor for objects of class BigBoy
     */
    public BigBoy(int x, int y, ImageIcon i)
    {
        super(x, y, i.getImage());
        lives = 3;
        cherries = 0;
    }

    //collects cherry
    public void collectCherry()
    {
        cherries++;
    }
    
    //reduces health by one (bitten by snake)
    public void takeHit()
    {
        lives--;
    }
    
    //jumps back when hit a snake
    public void jumpBack()
    {
        
    }
    
    //called when new level is started, or if level is restarted
    public void fullLives()
    {
        lives = 3;
    }
    
    //changes position based on up, right/left arrow keys
    public void jump()
    {
        
    }
    
    //changes position based on left and right arrow keys
    public void run()
    {
        setX(getX() + dx);
    }
    
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT)
        {
            dx = -2; //adjust values
        }
        
        if(key == KeyEvent.VK_RIGHT)
        {
            dx = 2; //adjust values
        }
        
        if(key == KeyEvent.VK_UP)
        {
            dy = 2; //>???? adjust values
        }
    }
    
    public void keyReleasesd (KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT)
        {
            dx = 0; 
        }
        
        if(key == KeyEvent.VK_RIGHT)
        {
            dx = 0; 
        }
        
        if(key == KeyEvent.VK_UP)
        {
            dy = 0; //idk
        }
    }
}
