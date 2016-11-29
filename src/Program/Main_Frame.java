package Program;

import javax.swing.*;
import java.awt.*;

public class Main_Frame extends JFrame{

    public Main_Frame(){
        super("Orbis");
        this.setSize(600,400);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new GridBagLayout());

        JButton B1 = new JButton("Inventory");
        JButton B2 = new JButton("BS TV");
        JButton B3 = new JButton("Manuals");
        JButton B4 = new JButton("Re Image");
        JButton B5 = new JButton("Programs");
        JButton B6 = new JButton("101. 100 SRV");
        JButton B7 = new JButton("Reeboot");

        B1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        B2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        B3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        B4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        B5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        B6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        B7.setCursor(new Cursor(Cursor.HAND_CURSOR));

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0.0;
        c.weighty = 0.9;
        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(1,2,3,4);




        this.add(B1,new GridBagConstraints(0,0,1,1,0,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(30,0,0,50),0,0));
        this.add(B2,new GridBagConstraints(1,0,1,1,0,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(30,50,0,0),0,0));
        this.add(B3,new GridBagConstraints(0,1,1,1,0,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(0,0,0,50),0,0));
        this.add(B4,new GridBagConstraints(1,1,1,1,0,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(0,50,0,0),0,0));
        this.add(B5,new GridBagConstraints(0,2,1,1,0,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(0,0,0,50),0,0));
        this.add(B6,new GridBagConstraints(1,2,1,1,0,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(0,50,0,0),0,0));
        this.add(B7,new GridBagConstraints(0,3,3,1,0,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(0,0,0,0),0,0));


        //new GridBagConstraints(0,1,1,1,0,1,GridBagConstraints.NORTHEAST,GridBagConstraints.HORIZONTAL,new Insets(2,2,2,2),0,0)

        this.setVisible(true);
    }
}
