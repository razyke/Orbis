package Frames;

import Functional.LinksforBTV;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class BTV extends JFrame{
    JTextField [] chanels;
    JButton reboot;
    JButton save;
    String[]tv;

    public BTV() throws IOException, ClassNotFoundException {
        super("BTV");
        this.setSize(600,400);
        this.setResizable(false);
        this.setLayout(new GridBagLayout());

        tv = LinksforBTV.getLinks();


        chanels = new JTextField[5];

        for (int i=0;i<5;i++){
            chanels[i] = new JTextField(10);
        }


        for (int i=0; i<5;i++){
            chanels[i].setText(tv[i]);
        }

        save = new JButton("Save");
        save.addActionListener(new Asave());



        this.add(chanels[0]);
        this.add(chanels[1]);
        this.add(chanels[2]);
        this.add(chanels[3]);
        this.add(chanels[4]);
        this.add(save,new GridBagConstraints(0,0,1,1,0,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(30,0,0,50),0,0));





        this.setVisible(true);
    }

    public class Asave implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                for (int i=0; i<5;i++){
                    tv[i] = chanels[i].getText();
                }
                LinksforBTV.save(tv);
            } catch (IOException e1) {
                e1.printStackTrace();
            }


        }
    }
}