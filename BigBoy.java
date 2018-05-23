
/**
 * Write a description of class BigBoy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BigBoy
{
    //instance variables
    private int lives, cherries;

    /**
     * Constructor for objects of class BigBoy
     */
    public BigBoy()
    {
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
        
    }
}
