package Frames;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Main_Frame extends JFrame {
    JButton B2;
    JButton B3;
    JButton B4;
    JButton B6;
    JButton B7;


    public Main_Frame() {
        super("Orbis");
        this.setSize(500, 300);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new GridBagLayout());

        Image im = Toolkit.getDefaultToolkit().getImage("Media\\icon-2.png");
        this.setIconImage(im);

        setContentPane(new BgPanel());
        Container cont = new Container();

        cont.setLayout(new GridBagLayout());


        B2 = new JButton("BTV");
        B3 = new JButton("Manuals");
        B4 = new JButton("Re-Image");
        B6 = new JButton("101. 100 SRV");
        B7 = new JButton("Reboot");


        B2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        B3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        B4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        B6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        B7.setCursor(new Cursor(Cursor.HAND_CURSOR));


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
        B4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reimage();
            }
        });

<<<<<<< HEAD
        B3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Desktop desktop = null;
                if (Desktop.isDesktopSupported()) {
                    desktop = Desktop.getDesktop();
                }

                try {
                    desktop.open(new File("S:\\Information Resources\\Help Desk\\01-Manual\\Main"));
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }

            }
        });

=======
        cont.add(B3, new GridBagConstraints(0, 1, 1, 1, 0, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(40, 0, 0, 50), 0, 0));
        cont.add(B4, new GridBagConstraints(1, 1, 1, 1, 0, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(40, 50, 0, 0), 0, 0));
        cont.add(B2, new GridBagConstraints(0, 2, 1, 1, 0, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(40, 0, 0, 50), 0, 0));
        cont.add(B6, new GridBagConstraints(1, 2, 1, 1, 0, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(40, 50, 0, 0), 0, 0));
        cont.add(B7, new GridBagConstraints(0, 3, 3, 1, 0, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(40, 0, 0, 0), 0, 0));
>>>>>>> refs/remotes/origin/testeing

        this.add(cont);
        this.setVisible(true);
    }

    class BgPanel extends JPanel {
        public void paintComponent(Graphics g) {
            Image im = null;
            try {
                im = ImageIO.read(new File("Media\\bg.jpg"));
            } catch (IOException e) {
            }
            g.drawImage(im, 0, 0, null);
        }
    }
}
