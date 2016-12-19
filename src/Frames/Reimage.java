package Frames;

import Functional.Functions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Reimage extends JFrame{
    JLabel NCN1;
    JLabel NCN2;
    JLabel NCN3;
    JButton AR;
    JTextArea names;
    JLabel description;

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
        AR = new JButton("Add+Run");

        AR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Functions.saverunHyberText(names.getText().split("\n"));
                } catch (IOException e1) {
                    e1.printStackTrace();

            }
            }
        });


        names = new JTextArea(5,10);
        description = new JLabel("<html>Данная программа устанавливает настройки при которых выставляется питание и уход в сон</html>");
        //<html>dddddddd<br> rrrrrrrrrrr</html>

        GridBagConstraints c = new GridBagConstraints();
        c.gridx=1;
        c.gridy=0;
        c.insets = new Insets(0,0,50,0);


        this.add(NCN1,c);
        c.gridx++;
        this.add(NCN2,c);
        c.gridx++;
        this.add(NCN3,c);
        c.gridy=3;
        c.gridx=0;
        c.insets = new Insets(30,0,0,0);
       this.add(names,c);
        c.gridx = 4;
        this.add(AR,c);
        c.gridx=0;
        c.gridy=5;
        //this.add(description,c);



        this.setVisible(true);
    }
}
