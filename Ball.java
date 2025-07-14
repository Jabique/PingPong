
public class Ball
{
    //default ball
    final int ballSize = 5;
    final int ballStartingX = 500;
    final int ballStartingY = 300;
    final int ballStartingSpeedX = 8; //go left, bc X - speed
    final int ballStartingSpeexY = 0;

    int ballSpeedX = 8;
    int ballSpeedY = 0;
    int ballX = 500;
    int ballY = 300;

    GamePanel gp;
    KeyHandler KeyH;

    public Ball(GamePanel gp, KeyHandler keyH)
    {
        this.gp = gp;
        this.KeyH = KeyH;
    }

    public void ball()
    {
        int leftPlayerX = gp.lp.leftPlayerX;
        int leftPlayerY = gp.lp.leftPlayerY;
        int leftSizeX = gp.lp.leftSizeX;
        int leftSizeY = gp.lp.leftSizeY; 
        int rightPlayerX = gp.rp.rightPlayerX;
        int rightPlayerY = gp.rp.rightPlayerY; 
        int rightSizeX = gp.rp.rightSizeX; 
        int rightSizeY = gp.rp.rightSizeY;
        /*$*================================================*$*/
        //ball bounce
        if(ballY <= 0 || ballY + ballSize >= gp.screenHeight) //top-bottom
        {
            ballSpeedY *= -1;
        }
        else if(ballX <= 0) //left
        {
            ballSpeedX *= -1;
            gp.menu.setGameState(false);
            gp.addScore("RIGHT");
            gp.menu.setReseter(true);
        }
        else if(ballX + ballSize >= gp.screenWidth) //right
        {
            ballSpeedX *= -1;
            gp.menu.setGameState(false);
            gp.addScore("LEFT");
            gp.menu.setReseter(true);
        }

        /*$*================================================*$*/
        //LEFT panel collider & bounce  16 + 16 + 16 + 16 = 64, diff angle

        //top 16
        if(

        ballX <= leftPlayerX + leftSizeX 
        && ballX >= leftPlayerX 

        && ballY <= leftPlayerY + 16 
        && ballY + ballSize >= leftPlayerY)

        {
            ballSpeedX = -4;
            ballSpeedY = 4;
        }
        //top mid 16
        else if(
        ballX <= leftPlayerX + leftSizeX 
        && ballX >= leftPlayerX 

        && ballY >= leftPlayerY + 16
        && ballY <= leftPlayerY + 32

        && ballY >= leftPlayerY)
        {
            ballSpeedX = -6;
            ballSpeedY = 2;
        }
        //bottom mid  16
        else if(
        ballX <= leftPlayerX + leftSizeX 
        && ballX >= leftPlayerX 

        && ballY >= leftPlayerY + 32
        && ballY <= leftPlayerY + 48

        && ballY >= leftPlayerY)
        {
            ballSpeedX = -6;
            ballSpeedY = -2;
        }
        //bottom 16
        else if(
        ballX <= leftPlayerX + leftSizeX 
        && ballX >= leftPlayerX 

        && ballY >= leftPlayerY + 48
        && ballY <= leftPlayerY + 64

        && ballY >= leftPlayerY)
        {
            ballSpeedX = -4;
            ballSpeedY = -4;
        }

        //RIGHT panel collider & bounce
        //top 16
        if(
        ballX + ballSize >= rightPlayerX 
        && ballX <= rightPlayerX 

        && ballY <= rightPlayerY + 16
        && ballY >= rightPlayerY)

        {
            ballSpeedX = 4;
            ballSpeedY = 4;
        }
        //top mid 16
        else if(
        ballX + ballSize >= rightPlayerX 
        && ballX <= rightPlayerX 

        && ballY >= rightPlayerY + 16 
        && ballY <= rightPlayerY + 32

        && ballY >= rightPlayerY
        )
        {
            ballSpeedX = 6;
            ballSpeedY = 2;
        }
        //bottom mid 16
        else if(
        ballX + ballSize >= rightPlayerX 
        && ballX <= rightPlayerX 

        && ballY >= rightPlayerY + 32 
        && ballY <= rightPlayerY + 48

        && ballY >= rightPlayerY
        )
        {
            ballSpeedX = 6;
            ballSpeedY = -2;
        }
        //bottom 16
        else if(
        ballX + ballSize >= rightPlayerX 
        && ballX <= rightPlayerX 

        && ballY >= rightPlayerY + 48 
        && ballY <= rightPlayerY + 64

        && ballY >= rightPlayerY
        )
        {
            ballSpeedX = 4;
            ballSpeedY = -4;
        }

    }

    public void ballMove(boolean state)
    {
        if(state == true){
            //Ball moving
            ballX -= ballSpeedX;
            ballY -= ballSpeedY;
        }
        else{}
    }

    public void reset()
    {
        ballSpeedX = ballStartingSpeedX;
        ballSpeedY = ballStartingSpeexY;
        ballX = ballStartingX;
        ballY = ballStartingY;
    }
}
