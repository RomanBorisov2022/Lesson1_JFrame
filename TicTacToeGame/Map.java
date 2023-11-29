package TicTacToeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    private static final Random RANDOM = new Random();
    private static final int DOT_PADDING = 5;

    private int gameOverType;
    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;

    private static final String MSG_WIN_HUMAN = "Победил игрок!";
    private static final String MSG_WIN_AI = "Победил компьютер!";
    private static final String MSG_DRAW = "Ничья!";
    private final int HUMAN_DOT = 1;
    private final int AI_DOT = 2;
    private final int EMPTY_DOT = 0;
    private int fieldSizeY = 3;
    private int fieldSizeX = 3;
    private  char[][] field;

    private boolean isGameOver;
    private boolean isInitialized;

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
        if(!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) return;
        field[cellX][cellY] = HUMAN_DOT;
        if (checkEndGame(HUMAN_DOT, STATE_WIN_HUMAN)) return;
        aiTurn();
        repaint();
        if (checkEndGame(AI_DOT, STATE_WIN_AI)) return;
    }
    private boolean checkEndGame(int dot, int gameOverType) {
        if (checkWin((char) dot)) {
            this.gameOverType = gameOverType;
            repaint();
            return true;
        }
        if (isMapFull()) {
            this.gameOverType = STATE_DRAW;
            repaint();
            return true;
        }
        return false;
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

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if(field[y][x] == EMPTY_DOT) continue;
                if(field[y][x] == HUMAN_DOT) {
                    g.setColor(Color.GREEN);
                    g.fillOval(x * cellWidth + DOT_PADDING,
                            y * cellHeigth + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeigth - DOT_PADDING * 2);
                } else if (field[y][x] == AI_DOT) {
                    g.setColor(new Color(0xff0000));
                    g.fillOval(x * cellWidth + DOT_PADDING,
                            y * cellHeigth + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeigth - DOT_PADDING * 2);
                } else {
                    throw new RuntimeException("Unexpected value " + field[x][y] + "in cell: " + x + " y=" + y);
                }
            }
            if (isGameOver) showMessageGameOver(g);
        }

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

    private void showMessageGameOver(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times new roman", Font.BOLD, 48));
        switch (gameOverType) {
            case STATE_DRAW: g.drawString(MSG_DRAW, 180, getHeight() / 2); break;
            case STATE_WIN_AI: g.drawString(MSG_WIN_AI, 20, getHeight() / 2); break;
            case STATE_WIN_HUMAN: g.drawString(MSG_WIN_HUMAN, 70, getHeight() / 2); break;
            default: throw new RuntimeException("Unexpected gameOver state: " + gameOverType);
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