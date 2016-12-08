package Functional;

import java.io.*;
import java.net.InetAddress;

/**
 * Created by CSTSMIRND on 03.12.2016.
 */
public class Functions {


    public static boolean Online(String name) throws IOException {
        if ((InetAddress.getByName(name)).isReachable(5000)){
            return true;
        }else
            return false;
    }

    public static void Rebooting (String name) throws IOException {
        String cmdComand = ("shutdown -r -t 1 -m \\\\"+name);

        Process go = Runtime.getRuntime().exec(cmdComand);
    }


    public static   String[] getLinks() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("BTV\\tv.dat"));
        Object object = in.readObject();
        LinksforBTV links = (LinksforBTV)object;
        String[] tv = new String[5];
        tv[0] = links.chanel1;
        tv[1] = links.chanel2;
        tv[2] = links.chanel3;
        tv[3] = links.chanel4;
        tv[4] = links.manager;
        in.close();
        return tv;
    }

    public static void save(String[] tv) throws IOException {
        LinksforBTV forsave = new LinksforBTV();
        forsave.chanel1 = tv[0];
        forsave.chanel2 = tv[1];
        forsave.chanel3 = tv[2];
        forsave.chanel4 = tv[3];
        forsave.manager = tv[4];

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("BTV\\tv.dat"));
        outputStream.writeObject(forsave);
        outputStream.close();

    }
}
