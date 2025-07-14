import java.awt.event.*;

public class KeyHandler implements KeyListener
{

    public boolean lUpPressed, lDownPressed, lLeftPressed, lRightPressed, 
                    rUpPressed, rDownPressed, rLeftPressed, rRightPressed, spacePressed;
                    
                    
                    
                    public KeyHandler(){}

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W)
        {
            lUpPressed = true;
        }

        if(code == KeyEvent.VK_S)
        {
            lDownPressed = true;
        }
        
        if(code == KeyEvent.VK_A)
        {
            lLeftPressed = true;
        }

        if(code == KeyEvent.VK_D)
        {
            lRightPressed = true;
        }
        
        ////right\/
        if(code == KeyEvent.VK_UP)
        {
            rUpPressed = true;
        }

        if(code == KeyEvent.VK_DOWN)
        {
            rDownPressed = true;
        }
        
        if(code == KeyEvent.VK_LEFT)
        {
            rLeftPressed = true;
        }

        if(code == KeyEvent.VK_RIGHT)
        {
            rRightPressed = true;
        }
        ////right/\
        
        if(code == KeyEvent.VK_SPACE)
        {
            spacePressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W)
        {
            lUpPressed = false;
        }

        if(code == KeyEvent.VK_S)
        {
            lDownPressed = false;
        }

        if(code == KeyEvent.VK_A)
        {
            lLeftPressed = false;
        }

        if(code == KeyEvent.VK_D)
        {
            lRightPressed = false;
        }
        
        ////right\/
        if(code == KeyEvent.VK_UP)
        {
            rUpPressed = false;
        }

        if(code == KeyEvent.VK_DOWN)
        {
            rDownPressed = false;
        }
        
        if(code == KeyEvent.VK_LEFT)
        {
            rLeftPressed = false;
        }

        if(code == KeyEvent.VK_RIGHT)
        {
            rRightPressed = false;
        }
        ////right/\
        
        if(code == KeyEvent.VK_SPACE)
        {
            spacePressed = false;
        }
    }
}
