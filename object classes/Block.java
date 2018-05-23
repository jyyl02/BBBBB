
/**
 * Write a description of class Block here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javax.swing.ImageIcon;
import java.awt.Image;

public class Block extends Sprite
{
    /**
     * Constructor for objects of class Block
     */
    public Block(int x, int y, ImageIcon i)
    {
        super(x, y, i.getImage());
    }
}
