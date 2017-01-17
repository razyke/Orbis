package Frames;

import Functional.Functions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class Reimage extends JFrame{
    JLabel NCN1;
    JLabel NCN2;
    JLabel NCN3;
    JButton AR;
    JTextArea names;
    JLabel description;
    JPanel area;
    JPanel NCN;

    public Reimage(){
        super("After re-image");
        this.setSize(600,400);
        this.setResizable(false);
        this.setLayout(new GridBagLayout());
        Image im = Toolkit.getDefaultToolkit().getImage("Media\\icon.png");
        this.setIconImage(im);


        NCN1 = new JLabel("WPET-");
        NCN2 = new JLabel("W7E-");
        NCN3 = new JLabel("D00185");
        NCN1.setFont(new Font("serif",Font.PLAIN,20));
        NCN2.setFont(new Font("serif",Font.PLAIN,20));
        NCN3.setFont(new Font("serif",Font.PLAIN,20));
        NCN1.setToolTipText("Локация");
        NCN2.setToolTipText("Версия Windows");
        NCN3.setToolTipText("Desktop, Portable,IPC...0-Petro,1-M&S");
        NCN = new JPanel();
        NCN.add(NCN1);
        NCN.add(NCN2);
        NCN.add(NCN3);

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
        names.setText("Тут вводите имена"+System.lineSeparator() +"компьютеров" +
                System.lineSeparator()+"построчно");
        names.setFont(new Font("serif",Font.PLAIN,11));
        names.addMouseListener(new MouseListener() {
            int count = 0;

            @Override
            public void mouseClicked(MouseEvent e) {
                if (count==0) {
                    names.setText("");
                    count++;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        AR.setCursor(new Cursor(Cursor.HAND_CURSOR));


        description = new JLabel("<html>При нажатии кнопки<br>"+ "задаются настройки питания<br>"+"для указанных компьютеров</html>");
        area = new JPanel();
        area.setBackground(Color.black);
        area.add(names);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx=0;
        c.gridy=0;
        c.insets = new Insets(0,0,20,0);
        this.add(NCN,c);
        c.gridy=3;
        c.gridx=0;
       this.add(area,c);
        c.gridx = 2;
        c.insets.set(0,0,20,10);
        this.add(AR,c);
        c.gridx=0;
        c.gridy=5;
        this.add(description,c);



        this.pack();
        this.setVisible(true);
    }
}
