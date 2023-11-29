package TicTacToeGame;
import javax.swing.*;
public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGTH = 230;
    public static final int WINDOW_WIDTH = 350;
    JButton btnStart = new JButton ("Start New Game");
    SettingsWindow(GameWindow gameWindow){
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGTH);
        add(btnStart);
    }
}
