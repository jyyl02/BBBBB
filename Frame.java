
/**
 * Write a description of class Frame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Frame
{
    // instance variables
    private int width, height;
    private int boardPos; //position of frame on board??
    
    /**
     * Constructor for objects of class Frame
     */
    public Frame()
    {
        width = 1000;
        height = 800;
        boardPos = 0;
    }
    
    public void scroll()
    {
        //boardPos moves??????
    }
}
