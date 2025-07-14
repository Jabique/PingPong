
import javax.swing.*;

import java.awt.*;

import java.util.Random;

public class RightPanel
{
    int screenHeight = 576;
    //default RIGHT
    final int rightPlayerDefaultX = 768 - 100;
    final int rightPlayerDefaultY = 576/2 - 32;

    int rightPlayerX = 768 - 100;
    int rightPlayerY = 576/2 - 32;
    int rightSizeX = 5;
    int rightSizeY = 64;

    int playerSpeed = 6;
    int botSpeed = 3;

    GamePanel gp;
    KeyHandler keyH;

    public RightPanel(GamePanel gp, KeyHandler keyH)
    {
        this.gp = gp;
        this.keyH = keyH;

    }

    public void move()
    {
        Random r = new Random();
        if(gp.getSP() != true)
        {
            ////right\/
            if ((keyH.rUpPressed == true || keyH.rRightPressed == true) && rightPlayerY >= 0)
            {
                rightPlayerY -= playerSpeed; // ==> playerY = playerY - playerSpeed
                //System.out.println("RIGHT UP");
            }

            else if ((keyH.rDownPressed == true || keyH.rLeftPressed == true) && rightPlayerY + rightSizeY <= screenHeight)
            {
                rightPlayerY += playerSpeed; // ==> playerY = playerY + playerSpeed
                //System.out.println("RIGHT DOWN");
            }
            ////right/\
        }

        else
        {
            int upOrDown = r.nextInt(2);
            int randPos = r.nextInt(rightSizeY/4 + 1);
            if(upOrDown == 1)
            {
                randPos *= -1;
            }
            if(gp.ball.ballX <= rightPlayerX)
            {
                if(rightPlayerY + rightSizeY/2  >= gp.ball.ballY)
                {
                    rightPlayerY -= botSpeed;
                }
                else if(rightPlayerY + rightSizeY/2 < gp.ball.ballY)
                {
                    rightPlayerY += botSpeed;
                }
                else if(rightPlayerY + rightSizeY/2 - 6 <= gp.ball.ballY && rightPlayerY + rightSizeY/2 + 6 >= gp.ball.ballY)
                {
                    rightPlayerY = rightPlayerY;
                }
            }
        }

    }

    public void reset()
    {
        rightPlayerX = rightPlayerDefaultX;
        rightPlayerY = rightPlayerDefaultY;
    }
}
