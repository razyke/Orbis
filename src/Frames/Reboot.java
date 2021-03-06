package Frames;


import Functional.Functions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Reboot extends JFrame {
    JTextField namePC;
    JButton ping;
    JButton reboot;

    public Reboot() {
        super("Reboot");
        this.setSize(300, 100);
        this.setResizable(false);
        this.setLayout(new GridBagLayout());
        Image im = Toolkit.getDefaultToolkit().getImage("Media\\icon.png");
        this.setIconImage(im);

        namePC = new JTextField(10);
        namePC.setText("wpet-w7e-");

        ping = new JButton("Ping");
        ping.setBackground(Color.GRAY);
        ping.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Functions.Online(namePC.getText()))
                        ping.setBackground(Color.GREEN);
                    else
                        ping.setBackground(Color.RED);
                } catch (IOException e1) {
                    ping.setBackground(Color.YELLOW);
                }
            }
        });

        ImageIcon re = new ImageIcon("Media\\reboot2.png");
        reboot = new JButton("",re);
        reboot.setBorderPainted(false);
        reboot.setFocusPainted(false);
        reboot.setContentAreaFilled(false);
        reboot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Functions.Online(namePC.getText()))
                        Functions.Rebooting(namePC.getText());

                } catch (IOException e1) {
                }
            }
        }
        );

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(0, 0, 0, 20);
        GridBagConstraints b = new GridBagConstraints();
        b.insets = new Insets(0,20,0,0);
        ping.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reboot.setCursor(new Cursor(Cursor.HAND_CURSOR));

        this.add(namePC, c);
        this.add(ping);
        this.add(reboot,b);


        this.setVisible(true);
    }
}
