package Frames;

import Functional.Functions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class BTV extends JFrame{
    JTextField [] chanels;
    JButton save;
    String[]tv;

    public BTV() throws IOException, ClassNotFoundException {
        super("BTV");
        this.setSize(450,400);
        this.setResizable(false);
        this.setLayout(new GridBagLayout());
        Image im = Toolkit.getDefaultToolkit().getImage("Media\\icon.png");
        this.setIconImage(im);

        tv = Functions.getLinks();

        chanels = new JTextField[5];
        for (int i=0;i<5;i++){
            chanels[i] = new JTextField(10);
        }

        for (int i=0; i<5;i++){
            chanels[i].setText(tv[i]);
        }

        chanels[4].setEditable(false);

        save = new JButton("Save");
        save.addActionListener(new Asave());
        ImageIcon re = new ImageIcon("Media\\reboot2.png");
        JButton reboot1 = new JButton("",re);
        JButton reboot2 = new JButton("",re);
        JButton reboot3 = new JButton("",re);
        JButton reboot4 = new JButton("",re);
        JButton manager = new JButton("Manager");
        save.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reboot1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reboot2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reboot3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reboot4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        manager.setCursor(new Cursor(Cursor.HAND_CURSOR));

        reboot1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Functions.Online(chanels[0].getText()))
                        Functions.Rebooting(chanels[0].getText());

                } catch (IOException e1) {
                }
            }
        });
        reboot2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Functions.Online(chanels[1].getText()))
                        Functions.Rebooting(chanels[1].getText());

                } catch (IOException e1) {
                }
            }
        });
        reboot3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Functions.Online(chanels[2].getText()))
                        Functions.Rebooting(chanels[2].getText());

                } catch (IOException e1) {
                }
            }
        });
        reboot4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Functions.Online(chanels[3].getText()))
                        Functions.Rebooting(chanels[3].getText());

                } catch (IOException e1) {
                }
            }
        });
        manager.addActionListener(new Amanager());

        JLabel admin = new JLabel("Админ.");
        JLabel prod = new JLabel("Прод.");
        JLabel lti = new JLabel("LTI.");
        JLabel reseprion = new JLabel("Ресеп");



        JLabel Description = new JLabel();
        Description.setText("<html>Перезагрузка каналов, сохранение при изменении<br>" + "подключение к менеджеру</html>");
        GridBagConstraints c = new GridBagConstraints();
        c.ipadx = 0;
        c.ipady = 0;
        Insets otstup = new Insets(0,0,50,0);
        c.insets = otstup;
        c.gridwidth=4;
        this.add(Description,c);
        c.gridwidth=1;
        c.gridy=2;
        otstup.set(0,0,20,30);
        this.add(chanels[0],c);
        c.gridy++;
        this.add(chanels[1],c);
        c.gridy++;
        this.add(chanels[2],c);
        c.gridy++;
        this.add(chanels[3],c);
        c.gridy++;
        this.add(chanels[4],c);
        c.gridy=2;
        c.gridx=1;
        otstup.set(0,30,20,0);
        this.add(admin,c);
        c.gridy++;
        this.add(prod,c);
        c.gridy++;
        this.add(lti,c);
        c.gridy++;
        this.add(reseprion,c);

        c.gridy=2;
        c.gridx=2;
        this.add(reboot1,c);
        c.gridy++;
        this.add(reboot2,c);
        c.gridy++;
        this.add(reboot3,c);
        c.gridy++;
        this.add(reboot4,c);
        c.gridy++;
        this.add(save,c);
        c.gridx--;
        this.add(manager,c);




        this.setVisible(true);
    }

    public class Asave implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                    for (int i=0; i<5;i++)
                 {
                    tv[i] = chanels[i].getText();
                 }
                Functions.save(tv);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }


    public class Amanager implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ProcessBuilder b = new ProcessBuilder("mstsc.exe \"BTV\\manager.rdp\"");
            try {
                b.start();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            JFrame action = new JFrame("use this");
            action.add(new JTextField("targetvision1"));
            action.setVisible(true);
            action.pack();
        }
    }
}
