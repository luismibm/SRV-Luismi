import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    public static void main(String[] args) {
        new Main().start();
    }

    public void start() {
        JButton button1 = new JButton("Mega Button1");
        button1.setBounds(0,0, 400,200);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActListener 1");
            }
        });
        add(button1);

        JButton button2 = new JButton("Mega Button2");
        button2.setBounds(0,200, 400,200);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActListener 2");
            }
        };
        button2.addActionListener(actionListener);
        add(button2);

        JButton button3 = new JButton("Mega Button3");
        button3.setBounds(0,400, 400,200);
        button3.addActionListener(actionListener);
        add(button3);

        setSize(400,630);
        setLayout(null);
        setVisible(true);

    }
}