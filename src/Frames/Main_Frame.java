package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main_Frame extends JFrame{
JButton B1;
JButton B2;
JButton B3;
JButton B4;
JButton B5;
JButton B6;
JButton B7;



    public Main_Frame(){
        super("Orbis");
        this.setSize(600,400);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new GridBagLayout());

        B1 = new JButton("Inventory");
        B2 = new JButton("BTV");
        B3 = new JButton("Manuals");
        B4 = new JButton("Re-Image");
        B5 = new JButton("Programs");
        B6 = new JButton("101. 100 SRV");
        B7 = new JButton("Reboot");

        B1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        B2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        B3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        B4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        B5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        B6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        B7.setCursor(new Cursor(Cursor.HAND_CURSOR));

        /*GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.0;
        c.weighty = 0.9;
        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(1,2,3,4);
        c.ipadx = 0;
        c.ipady = 0;
        new GridBagConstraints(0,1,1,1,0,1,GridBagConstraints.NORTHEAST,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0)
        */

       B7.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               new Reboot();
           }
       });
       B2.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try {
                   new BTV();
               } catch (IOException e1) {
                   e1.printStackTrace();
               } catch (ClassNotFoundException e1) {
                   e1.printStackTrace();
               }
           }
       });
       B6.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               new srv();
           }
       });



        this.add(B1,new GridBagConstraints(0,0,1,1,0,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(30,0,0,50),0,0));
        this.add(B2,new GridBagConstraints(1,0,1,1,0,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(30,50,0,0),0,0));
        this.add(B3,new GridBagConstraints(0,1,1,1,0,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(0,0,0,50),0,0));
        this.add(B4,new GridBagConstraints(1,1,1,1,0,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(0,50,0,0),0,0));
        this.add(B5,new GridBagConstraints(0,2,1,1,0,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(0,0,0,50),0,0));
        this.add(B6,new GridBagConstraints(1,2,1,1,0,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(0,50,0,0),0,0));
        this.add(B7,new GridBagConstraints(0,3,3,1,0,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(0,0,0,0),0,0));




        this.setVisible(true);
    }
}
