package Functional;

import java.io.IOException;
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
}
