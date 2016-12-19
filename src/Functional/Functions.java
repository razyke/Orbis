package Functional;

import java.io.*;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Functions {


    public static boolean Online(String name) throws IOException {
        if ((InetAddress.getByName(name)).isReachable(5000)) {
            return true;
        } else
            return false;
    }

    public static void Rebooting(String name) throws IOException {
        String cmdComand = ("shutdown -r -t 1 -m \\\\" + name);

        Process go = Runtime.getRuntime().exec(cmdComand);
    }


    public static String[] getLinks() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("BTV\\tv.dat"));
        Object object = in.readObject();
        LinksforBTV links = (LinksforBTV) object;
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

    public static void LoggOff101(String name) throws IOException, InterruptedException {

        ProcessBuilder cmd = new ProcessBuilder("100_101srv\\101.cmd");
        cmd.start();

        Thread.sleep(1500);

        BufferedReader reader = new BufferedReader(new FileReader("100_101srv\\101.txt"));
        Map<Integer,String> users_id = new HashMap<>();
        while (reader.ready()) {
            String stroka = reader.readLine();
            stroka = stroka.toLowerCase();
            String user = stroka.substring(18, 33);
            user = user.trim();
            int id=0;

            try {
                id = Integer.parseInt(stroka.substring(41, 46).trim());
            } catch (Exception e) {}
            users_id.put(id,user);
        }

        int FID = -1;

            for (Map.Entry<Integer,String> pair : users_id.entrySet()) {
                if (name.equals(pair.getValue())) {
                    FID = pair.getKey();
                }
            }
            String comand = "logoff "+FID+ " /server:ruspet01-srv101";
        System.out.println(comand);
            Runtime.getRuntime().exec(comand);
        }



        public static void LoggOff837() throws IOException, InterruptedException{
            String name = "petwmstw01";
            ProcessBuilder cmd = new ProcessBuilder("100_101srv\\100.cmd");
            cmd.start();
            Thread.sleep(1500);

            BufferedReader reader = new BufferedReader(new FileReader("100_101srv\\100.txt"));
            Map<Integer,String> users_id = new HashMap<>();
            while (reader.ready()) {
                String stroka = reader.readLine();
                stroka = stroka.toLowerCase();
                String user = stroka.substring(18, 33);
                user = user.trim();
                int id=0;

                try {
                    id = Integer.parseInt(stroka.substring(41, 46).trim());
                } catch (Exception e) {}
                users_id.put(id,user);
            }

            int FID = -1;

            for (Map.Entry<Integer,String> pair : users_id.entrySet()) {
                if (name.equals(pair.getValue())) {
                    FID = pair.getKey();
                }
            }
            String comand = "logoff "+FID+ " /server:ruspet01-srv100";
            Runtime.getRuntime().exec(comand);

        }

        public static void saverunHyberText(String[] arr) throws IOException {

            FileWriter fileWriter = new FileWriter("Hibernate\\hiblist.txt");



            for (int i=0;i<arr.length;i++) {
                fileWriter.write(arr[i]);
                fileWriter.write(System.lineSeparator());
            }

            fileWriter.close();

           // Runtime.getRuntime().exec("cmd /c Hibernate\\Remove hibernate.bat");
            ProcessBuilder go = new ProcessBuilder("psexec -c /accepteula @hiblist.txt powercfg.bat");
            go.start();
        }

        //public static
    }

