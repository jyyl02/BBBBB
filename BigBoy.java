/**
 * Write a description of class BigBoy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class BigBoy
{
    //instance variables
    private int lives, cherries; 
    private int dx; // x displacement
    private int bx1, bx2; //background image one + two *****
    private int x, y; //x and y location
    Image bB;
    //figure out images
        ImageIcon facingLeft = new ImageIcon("bigboy-right.png");
        //ImageIcon facingRight = new ImageIcon("");
        //ImageIcon jumping = new ImageIcon("");
    
    /**
     * Constructor for objects of class BigBoy
     */
    public BigBoy()
    {
        //adjust values
        x = 50;
        y = 120; //on top of 2 rows of blocks (60 ea) 
        bx1 = 0;
        bx2 = -750;
        
        
        //bB = facingRight.getImage();
    }
    
    //changes position left/right
    public void run(boolean right)
    {
        if(x > 0 && x < 750)
        {
            if(right)
            {
                //bB = facingRight.getImage();
                x += dx;
            }
            else
            {
                //bB = facingLeft.getImage();
                x -= dx;
            }
        }
        
        /*
        if(x <= 0)
        {
            x = 1;
            bx1 += dx / 2; //slows down bg speed
            bx2 += dx / 2;
        }
        
        if(x >= 750)
        {
            x = 749;
            bx1 += dx / 2; //slows down bg speed
            bx2 += dx / 2;
        }
        */
       
        //need??
    }
    
    //changes position based on up, right/left arrow keys
    public  void jump()
    {
        if(checkCollisions() == 1) //if x/y value is on a block
        {
            
        }
        
        while(checkCollisions() != 1) //while x/y value is in the air
        {
            y -= 2; //adjust value
        }
    }
    
    public int checkCollisions()
    {
        //if bigboy x position is hitting a block
        //return 0
        // if y pos hitting block 
        //return 1
        //if cherry hit
        //return 2
        
        return -1;
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
    
    //jumps in the same direction as the snake attack
    public void jumpBack()
    {
        
    }
    
    //called when new level is started, or if level is restarted
    public void fullLives()
    {
        lives = 3;
    }
    
    public void setDx(int x)
    {
        dx = x;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    } 
    
        public int getCherries()
    {
        return cherries;
    }
    
    public int getLives()
    {
        return lives;
    }
    
    public Image getImage()
    {
        return bB;
    }

    
    
    
    /*
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
        
        /*
        if(key == KeyEvent.VK_UP)
        {
            dy = 0; //idk
        }
        
    }
    
    */
}
