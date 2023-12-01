package TicTacToeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowChatClient extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 700;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;

    JLabel labelLogin = new JLabel(" Login:");
    JTextField loginField = new JTextField();
    JLabel labelPassword = new JLabel(" Password:");
    JTextField passwordField = new JTextField();
    JLabel labelIP = new JLabel(" IP:");
    JTextField ipField = new JTextField();
    JButton btnSend = new JButton("Отправить");
    JLabel labelMSG = new JLabel(" Сообщение:");
    JTextField msgField = new JTextField();
    JTextArea areaMessage = new JTextArea();
    JPanel panServer = new JPanel(new GridLayout(6,1));
    JPanel panMessage = new JPanel(new GridLayout(4,1));
    String login;
    String password;
    String ip;
    String message;
    WindowChatClient() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Client Window");
        setResizable(false);

        panServer.add(labelLogin);
        panServer.add(loginField);
        panServer.add(labelPassword);
        panServer.add(passwordField);
        panServer.add(labelIP);
        panServer.add(ipField);

        panMessage.add(btnSend);
        panMessage.add(labelMSG);
        panMessage.add(msgField);
        panMessage.add(btnSend);
        panMessage.add(areaMessage);

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message = loginField.getText() + ": " + msgField.getText() + "\n";
                areaMessage.append(message);
                System.out.println("Отправлено: " + message);
            }
        });
        setLayout(new GridLayout(2, 1));
        add(panServer);
        add(panMessage);
        setVisible(true);
    }

    public static void main(String[] args) {
        new WindowChatClient();
    }
}
