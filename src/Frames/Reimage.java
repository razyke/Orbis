package Frames;

import javax.swing.*;
import java.awt.*;


public class Reimage extends JFrame{
    JLabel NCN1;
    JLabel NCN2;
    JLabel NCN3;
    JButton add;
    JButton run;
    JTextField names;

    public Reimage(){
        super("Re-image");
        this.setSize(600,400);
        this.setResizable(false);
        this.setLayout(new GridBagLayout());

        NCN1 = new JLabel("WPET-");
        NCN2 = new JLabel("W7E-");
        NCN3 = new JLabel("D00185");
        NCN1.setFont(new Font("serif",Font.PLAIN,20));
        NCN2.setFont(new Font("serif",Font.PLAIN,20));
        NCN3.setFont(new Font("serif",Font.PLAIN,20));
        NCN1.setToolTipText("Локация");
        NCN2.setToolTipText("Версия Windows");
        NCN3.setToolTipText("Desktop, Portable,IPC...0-Petro,1-M&S");

        names = new JTextField(15);
        names.setSize(20,50);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx=0;
        c.gridy=0;

        this.add(NCN1,c);
        c.gridx++;
        this.add(NCN2,c);
        c.gridx++;
        this.add(NCN3,c);
        c.gridy++;
        c.gridx=0;
        c.gridwidth = 2;
        c.gridheight = 2;
        c.weightx = 2;
        c.weighty = 2;
       // this.add(names,c);

















        this.setVisible(true);
    }
}
