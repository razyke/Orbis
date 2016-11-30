package Functional;

import java.io.IOException;
import java.net.InetAddress;

public class Ping {

    public static boolean Online(String name) throws IOException {
        if ((InetAddress.getByName(name)).isReachable(5000)){
            return true;
        }else
            return false;
    }

}
