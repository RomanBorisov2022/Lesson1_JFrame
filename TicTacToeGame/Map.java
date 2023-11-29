package TicTacToeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    private static final Random RANDOM = new Random();
    private final int HUMAN_DOT = 1;
    private final int AI_DOT = 2;
    private final int EMPTY_DOT = 0;
    private int fieldSizeY = 3;
    private int fieldSizeX = 3;
    private  char[][] field;

    private void initMap(){
        fieldSizeY = 3;
        fieldSizeX = 3;
        field = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    private void aiTurn() {
        int x, y;
        do{
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[x][y] = AI_DOT;
    }

    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }
    private boolean isEmptyCell(int x, int y) {
        return field[y][x] == EMPTY_DOT;
    }

    private int panelWidth;
    private int panelHeigth;
    private int cellHeigth;
    private int cellWidth;
    Map() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                update(e);
            }
        });
    }
    private void update(MouseEvent e){
        int cellX = e.getX()/cellWidth;
        int cellY = e.getY()/cellHeigth;
        System.out.printf("x=%d, y=%d\n", cellX, cellY);
        repaint();
    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        System.out.printf("Mode: %d;\nSize: x=%d, y=%d\nWin Length: %d", mode, fSzX, fSzY, wLen);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g){

        panelWidth = getWidth();
        panelHeigth = getHeight();
        cellHeigth = panelHeigth / 3;
        cellWidth = panelWidth / 3;

        g.setColor(Color.BLACK);
        for (int h = 0; h < 3; h++) {
            int y = h * cellHeigth;
            g.drawLine(0, y, panelWidth, y);
        }
        for (int w = 0; w < 3; w++) {
            int x = w * cellWidth;
            g.drawLine(x, 0, x, panelHeigth);
        }
    }

    private boolean checkWin(char c) {
        // Проверка по горизонтали и вертикали
        for (int i = 0; i < field.length; i++) {
            boolean rowWin = true;
            boolean colWin = true;

            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] != c) {
                    rowWin = false;
                }

                if (field[j][i] != c) {
                    colWin = false;
                }
            }

            if (rowWin || colWin) {
                return true;
            }
        }

        // Проверка диагоналей
        boolean diag1Win = true;
        boolean diag2Win = true;

        for (int i = 0; i < field.length; i++) {
            if (field[i][i] != c) {
                diag1Win = false;
            }

            if (field[i][field[i].length - 1 - i] != c) {
                diag2Win = false;
            }
        }

        return diag1Win || diag2Win;
    }

    private boolean isMapFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if(field[i][j] ==EMPTY_DOT) return false;
            }
        }
        return true;
    }

}