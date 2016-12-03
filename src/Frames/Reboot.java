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

        namePC = new JTextField(10);
        namePC.setText("wpet-w7e-");

        ping = new JButton("Ping");
        ping.setBackground(Color.GRAY);
        ping.addActionListener(new PingListener());

        ImageIcon re = new ImageIcon("C:\\reboot2.gif");
        reboot = new JButton("",re);
        reboot.addActionListener(new RebootListener());

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


    public class PingListener implements ActionListener {

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
    }

    public class RebootListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (Functions.Online(namePC.getText()))
                Functions.Rebooting(namePC.getText());

            } catch (IOException e1) {
            }
        }
    }
}
