package Frames;

import Functional.Functions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

public class srv extends JFrame {
    JTextField name;
    JRadioButton wm6;
    JRadioButton wce;
    ButtonGroup terminal;
    String fullname = "";
    JButton restartRS;

    public srv() {

        super("100 and 101 server");
        this.setSize(600, 400);
        this.setResizable(false);
        this.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();


        JButton logoff101 = new JButton("Log Off");
        logoff101.addActionListener(new Alogoff101());
        JButton palitizator = new JButton("Palitizator/837");

        terminal = new ButtonGroup();

        wm6 = new JRadioButton("WM6",true);
        wce = new JRadioButton("WCE",false);
        restartRS = new JButton("Restart report servis( 101)");
        restartRS.setFont(new Font("serif",Font.PLAIN,12));
        restartRS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Functions.reportRestart();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        terminal.add(wm6);
        terminal.add(wce);

        name = new JTextField(4);
        palitizator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Functions.LoggOff837();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });




        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10,10,10,10);
        this.add(name,c);
        c.gridx++;
        this.add(logoff101,c);
        c.gridy++;
        c.gridx--;
        this.add(wm6,c);
        c.gridx++;
        this.add(wce,c);
        c.gridy++;
        c.insets = new Insets(30,0,0,20);
        c.gridx--;
        this.add(palitizator,c);
        c.gridx++;
        c.insets.set(30,0,0,0);
        this.add(restartRS,c);

        c.gridwidth =2;
        c.gridheight = 1;


        fullname = "z_petwmstm";





        wm6.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                fullname = "z_petwmstm";
            }
        });

        wce.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                fullname = "z_petwmstf";
            }
        });


        this.pack();
        this.setVisible(true);
    }

    private class Alogoff101 implements ActionListener{
        String end;

        @Override
        public void actionPerformed(ActionEvent e) {
            end = fullname + name.getText();

            try {
                Functions.LoggOff101(end);
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }


        }
    }

}
