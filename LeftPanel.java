
import javax.swing.*;

import java.awt.*;

public class LeftPanel
{
    int screenHeight = 576;
    //default LEFT
    final int leftPlayerDefaultX = 100;
    final int leftPlayerDefaultY = 576/2 - 32;
    
    int leftPlayerX = 100;
    int leftPlayerY = 576/2 - 32;
    int leftSizeX = 5;
    int leftSizeY = 64;

    int playerSpeed = 8;

    GamePanel gp;
    KeyHandler keyH;
    public LeftPanel(GamePanel gp, KeyHandler keyH)
    {
        this.gp = gp;
        this.keyH = keyH;

        //int playerSpeed = gp.playerSpeed;
        //int screenHeight = gp.screenHeight;
    }

    public void move()
    {

        ////left\/
        if ((keyH.lUpPressed == true || keyH.lLeftPressed == true) && leftPlayerY >=0)
        {
            leftPlayerY -= playerSpeed; // ==> playerY = playerY - playerSpeed
            System.out.println("UP or LEFT " + leftPlayerY + " " + playerSpeed);
            System.out.println(screenHeight);

        }
        if ((keyH.lDownPressed == true || keyH.lRightPressed == true) && leftPlayerY + leftSizeY <= screenHeight)
        {
            leftPlayerY += playerSpeed; // ==> playerY = playerY + playerSpeed
            System.out.println("RIGHT OR DOWN PRESSED");
        }

        ////left/\
    }
    
    public void reset()
    {
        leftPlayerX = leftPlayerDefaultX;
        leftPlayerY = leftPlayerDefaultY;
    }
}
