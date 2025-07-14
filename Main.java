import javax.swing.*;

public class Main
{
    public boolean gameActive = false;
    public boolean SP;
    public static void main(String[] args)
    {
        Menu menu = new Menu();

        JFrame window = new JFrame();
        window.setJMenuBar(menu.menuBar);//

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("52");

        GamePanel gamePanel = new GamePanel(menu);
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();

        ///======================================================
    }

    public Main()
    {
        Menu menu = new Menu();

        JFrame window = new JFrame();
        window.setJMenuBar(menu.menuBar);//

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("52");

        GamePanel gamePanel = new GamePanel(menu);
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
    }
    public Main(boolean SP/*, String type_II, String name_I, String name_II*/)
    {
        Menu menu = new Menu();

        JFrame window = new JFrame();
        window.setJMenuBar(menu.menuBar);//

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("52");
        this.SP = SP;

        GamePanel gamePanel = new GamePanel(menu, SP);
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
    }
}
