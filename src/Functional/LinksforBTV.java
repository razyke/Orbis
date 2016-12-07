package Functional;

import java.io.*;


public class LinksforBTV implements Serializable {

    String chanel1 = "wpet-w7e-d00541";
    String chanel2 = "wpet-w7e-d00540";
    String chanel3 = "wpet-w7e-d00545";
    String chanel4 = "wpet-w7e-d00178";
    String manager = "wpet-w7e-d00449";

    public LinksforBTV(){}


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
