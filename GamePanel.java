
import javax.swing.*;

import java.awt.*;

public class GamePanel extends JPanel implements Runnable
{
    //screen settings
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3;

    final int tileSize = originalTileSize * scale; //48x48
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; //768
    final int screenHeight = tileSize * maxScreenRow; //576

    public boolean gameActive = false;

    //fps
    int FPS = 60;
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    
    public boolean SP;
    
    public Menu menu;
    public Ball ball;
    public LeftPanel lp;
    public RightPanel rp;
    public GamePanel(Menu menu, boolean singlePlayer)
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

        this.addKeyListener(keyH);
        this.setFocusable(true); //gamePanel can be "focused" to recieve key input

        this.menu = menu;
        this.SP = singlePlayer;

        ball = new Ball(this, keyH);
        lp = new LeftPanel(this, keyH);
        rp = new RightPanel(this, keyH);

    }

    public GamePanel(Menu menu)
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

        this.addKeyListener(keyH);
        this.setFocusable(true); //gamePanel can be "focused" to recieve key input

        this.menu = menu;

        ball = new Ball(this, keyH);
        lp = new LeftPanel(this, keyH);
        rp = new RightPanel(this, keyH);

    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() 
    {

        double drawInterval = 1000000000/FPS; //i bil nanoseconds; 0,01666 s
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null)
        {
            //long currentTime = System.nanoTime();
            //long currentTime2 = System.currentTimeMillis(); not precise
            //System.out.println("Time: " + currentTime);

            //Update
            update();

            //Drawing
            repaint(); // = paintComponent()

            try{
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000; //conv to milis

                if(remainingTime < 0)
                {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void update() 
    {

        /*$*================================================*$*/
        lp.move();
        rp.move();
        ball.ball();
        ball.ballMove(menu.gameActive);
        reset();
        /*
        if(menu.gameActive == true)
        {
        gameActive = true;
        System.out.println("Game State: true");
        }
        else if (menu.gameActive == false)
        {
        gameActive = false;
        System.out.println("Game State: false");
        }*/
        pause();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g; //1d -> 2d + functns

        g2.setColor(Color.GREEN);

        g2.fillRect(lp.leftPlayerX, lp.leftPlayerY, lp.leftSizeX, lp.leftSizeY); //x y w h LEFT

        g2.fillRect(rp.rightPlayerX, rp.rightPlayerY, rp.rightSizeX, rp.rightSizeY); //x y w h RIGHT

        g2.fillRect(ball.ballX, ball.ballY, ball.ballSize, ball.ballSize); //x y w h BALL

        g2.dispose(); //draw and release any system resources that it (g) is using
    }

    public void reset()
    {
        if(menu.reseter == true){
            ball.reset();
            lp.reset();
            rp.reset();
            menu.setReseter(false);
            menu.setGameState(false);
        }
    }

    public void pause()
    {
        if(keyH.spacePressed == true && menu.gameActive == true)
        {
            menu.setGameState(false);
            keyH.spacePressed = false;
        }
        else if(keyH.spacePressed == true && menu.gameActive == false)
        {
            menu.setGameState(true);
            keyH.spacePressed = false;
        }
    }
    public boolean getSP()
    {
        return SP;
    }

}
