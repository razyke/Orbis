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

        JLabel Description = new JLabel();
        Description.setText("В этом окне, вы можете перезагружать");
        GridBagConstraints c = new GridBagConstraints();
        Insets otstup = new Insets(0,0,100,0);
        c.gridx = 0;
        c.gridy = 0;
        c.insets = otstup;
        c.anchor = GridBagConstraints.NORTH;


        this.add(Description,c);
        c.anchor= GridBagConstraints.CENTER;
        otstup.set(0,0,20,0);
        c.gridy++;
        this.add(chanels[0],c);
        c.gridy++;
        this.add(chanels[1],c);
        c.gridy++;
        this.add(chanels[2],c);
        c.gridy++;
        this.add(chanels[3],c);
        c.gridy++;
        this.add(chanels[4],c);
        c.gridy++;
       this.add(save,c);





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
