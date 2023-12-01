package TicTacToeGame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGTH = 230;
    public static final int WINDOW_WIDTH = 350;
    JButton btnStart = new JButton("Start New Game");
    JLabel gameLabel = new JLabel("Выберите режим игры: ");
    JLabel gameMap = new JLabel("Установите размер поля:");
    JSlider mapLength = new JSlider(3,10);
    JLabel fieldWin = new JLabel("Выберите длинну для победы: ");
    JSlider winLength = new JSlider(3,10);
    JRadioButton humVsAi = new JRadioButton("Человек против компьютера");
    JRadioButton humVsHum = new JRadioButton("Человек против Человека");
    ButtonGroup buttonGroup = new ButtonGroup();

    JPanel panButton;

    SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGTH);
        panButton = new JPanel(new GridLayout(8,1));
        panButton.add(gameLabel);
        buttonGroup.add(humVsAi);
        buttonGroup.add(humVsHum);
        panButton.add(humVsAi);
        panButton.add(humVsHum);
        panButton.add(gameMap);
        panButton.add(mapLength);
        panButton.add(fieldWin);
        panButton.add(winLength);
        panButton.add(btnStart);
        humVsAi.setSelected(true);
        mapLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gameMap.setText("Установите размер поля:" + mapLength.getValue());
            }
        });
        winLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                fieldWin.setText("Выберите длинну для победы: " + winLength.getValue());
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(
                        humVsAi.isSelected()?0:1,
                        mapLength.getValue(),
                        mapLength.getValue(),
                        winLength.getValue()
                );
                setVisible(false);
            }
        });
        add(panButton);
    }
}
