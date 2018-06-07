/**
 * Write a description of class BigBoy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javafx.scene.image.Image;
import java.awt.event.KeyEvent;
import javafx.scene.canvas.GraphicsContext;

public class BigBoy
{
    //instance variables
    private int lives, cherries;
    private Level level;
    private double dx, dy; // x displacement
    //private int bx1, bx2; //background image one + two *****
    private double x, y; //x and y location
    private int width, height;
    
    private boolean left, right, jumping, falling;
    private boolean topLeft, topRight, botLeft, botRight;
    private double runSpeed, maxSpeed, maxFallingSpeed, stopSpeed, jumpStart,
    gravity;
    Image bB;
    //figure out images
    //private Image facingLeft = new Image("bigboy-left.png");
    //private Image facingRight = new Image("bigboy-right.png");
    //private Image runningLeft = new Image("bigboy-running-left.gif");
    //private Image runningRight = new Image("bigboy-running-right.gif");
    //private Image jumpingLeft = new Image("bigboy-jumpingUp-left.gif");
    //private Image jumpingRight = new Image("bigboy-jumpingUp-right.gif");
    //private Image fallingLeft = new Image("bigboy-falling-left.png");
    //private Image fallingRight = new Image("bigboy-falling-right.png");
    
    /**
     * Constructor for objects of class BigBoy
     */
    public BigBoy(Level l)
    {
        //adjust values
        level = l;
        
        width = 40;
        height = 50;
        x = 50;
        y = 120; //on top of 2 rows of blocks (60 ea) 
        runSpeed = 2;
        maxSpeed = 5;
        maxFallingSpeed = 15;
        stopSpeed = .3;
        jumpStart = -12;
        gravity = .64;
        //bx1 = 0;
        //bx2 = -750;
        //bB = facingRight;
    }
    
    /*
    //changes position left/right
    public void move()
    {
        if(x > 0 && x < 750)
        {
            if(right)
            {
                //bB = facingRight;
                dx += runSpeed;
                if(dx > maxSpeed)
                {
                    dx = maxSpeed;
                }
            }
            else if(left)
            {
                //bB = facingLeft;
                dx -= runSpeed;
                if(dx < maxSpeed)
                {
                    dx = -maxSpeed;
                }
            }
            else
            {
                if(dx > 0)
                {
                    dx -= stopSpeed;
                    if(dx < 0)
                    {
                        dx = 0;
                    }
                }
                else if (dx < 0)
                {
                    dx += stopSpeed;
                    if(dx > 0)
                    {
                        dx = 0;
                    }
                }
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
       
        //need??*/
    //}
    
    /*
    //changes position based on up, right/left arrow keys
    public void jump()
    {
        /*if(checkCollisions() == 1) //if x/y value is on a block
        {
            
        }
        
        while(checkCollisions() != 1) //while x/y value is in the air
        {
            y -= 2; //adjust value
        }
        
        if(jumping)
        {
            dy = jumpStart;
            falling = true;
            jumping = false;
        }
        
        if(falling)
        {
            dy += gravity;
            if(dy > maxFallingSpeed)
            {
                dy = maxFallingSpeed;
            }
        }*/
    //}
    
    
    public void checkCollisions()
    {
        int currentX = level.getXPos((int)x);
        int currentY = level.getYPos((int)y);
        
        double toX = x + dx;
        double toY = y + dy;
        
        double tempX = x;
        double tempY = y;
        
        calculateCorners(x, toY);
        
        if(dy < 0) //moving up, so topLeft/topRight are checked
        {
            if(topLeft || topRight)
            {
                dy = 0;
                tempY = currentY * level.getTileSize() + height / 2;
            }
            else //haven't bumped head, still free to move
            {
                tempY += dy;
            }
        }
        
        if(dy > 0) //moving down, botLeft/botRight checked
        {
            if(botLeft || botRight)
            {
                dy = 0;
                falling = false;
                tempY = (currentY + 1) * level.getTileSize() - height / 2;
            }
            else
            {
                tempY += dy;
            }
        }
        
        calculateCorners(toX, y);
        if(dx < 0) //moving left
        {
            if(topLeft || botLeft)
            {
                dx = 0;
                tempY = currentX * level.getTileSize() + width / 2;
            }
            else
            {
                tempX += dx;
            }
        }
        
        if(dx > 0) //moving right
        {
            if(topRight || botRight)
            {
                dy = 0;
                tempY = (currentX + 1) * level.getTileSize() - width / 2;
            }
            else
            {
                tempX += dx;
            }
        }
        
        if(!falling)
        {
            calculateCorners(x, y + 1);
            if(!botLeft && !botRight)
            {
                falling = true;
            }
        }
        
        x = tempX;
        y = tempY;
        
        //scroll the map
        if(x > 50 && x < 700)
        {
            level.setX((int) (750 / 2 - x));
        }
    }
    
    public void run(GraphicsContext gc)
    {
        if(x > 0 && x < 750)
        {
            if(right)
            {
                //bB = facingRight;
                dx += runSpeed;
                if(dx > maxSpeed)
                {
                    dx = maxSpeed;
                }
            }
            else if(left)
            {
                //bB = facingLeft;
                dx -= runSpeed;
                if(dx < maxSpeed)
                {
                    dx = -maxSpeed;
                }
            }
            else
            {
                if(dx > 0)
                {
                    dx -= stopSpeed;
                    if(dx < 0)
                    {
                        dx = 0;
                    }
                }
                else if (dx < 0)
                {
                    dx += stopSpeed;
                    if(dx > 0)
                    {
                        dx = 0;
                    }
                }
            }
        }
        
        if(jumping)
        {
            dy = jumpStart;
            falling = true;
            jumping = false;
        }
        
        if(falling)
        {
            dy += gravity;
            if(dy > maxFallingSpeed)
            {
                dy = maxFallingSpeed;
            }
        }
    }
    
    private void calculateCorners(double x, double y)
    {
        int leftTile = level.getXPos((int) (x - width / 2));
        int rightTile = level.getXPos((int) (x + width / 2) - 1);
        int topTile = level.getYPos((int) (y - height / 2));
        int botTile = level.getYPos((int) (y + height / 2) - 1);
        
        topLeft = level.getTile(topTile, leftTile) == 0;
        topRight = level.getTile(topTile, rightTile) == 0;
        botLeft = level.getTile(botTile, leftTile) == 0;
        botRight = level.getTile(botTile, rightTile) == 0;
    }
    
    //collects cherry
    public void collectCherry()
    {
        cherries++;
    }
    
    //called when new level is started, or if level is restarted
    //need or not??
    public void fullLives()
    {
        lives = 3;
    }
    
    public void setDx(int x)
    {
        dx = x;
    }
    
    public double getX()
    {
        return x;
    }
    
    public double getY()
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
    
    public void setLeft(boolean b)
    {
        left = b;
    }
    
    public void setRight(boolean b)
    {
        right = b;
    }
    
    public void setJumping(boolean b)
    {
        jumping = b;
    }
    
    public void setFalling(boolean b)
    {
        falling = b;
    }
    
        public int getCherries()
    {
        return cherries;
    }
    
    public int getLives()
    {
        return lives;
    }
    
    public void loseLife()
    {
        lives--;
    }
    
    public Image getImage()
    {
        return bB;
    }
}
