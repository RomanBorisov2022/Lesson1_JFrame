package TicTacToeGame;

import TicTacToeGame.GameWindow;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args){
        new GameWindow();
        System.out.println("Method main() is over");
    }

    public static class Map extends JPanel {
        Map(){
            setBackground(Color.BLACK);
        }
    }
}
