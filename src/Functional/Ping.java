package Functional;

import java.io.IOException;
import java.net.InetAddress;

public class Ping {
    public static void main(String[] args) throws IOException {
        String ipAddress = "WPET-W7E-P00142";
        InetAddress inet = InetAddress.getByName(ipAddress);

        System.out.println("Sending Ping Request to " + ipAddress);
        System.out.println(inet.isReachable(5000) ? "Host is reachable" : "Host is NOT reachable");

        ipAddress = "173.194.32.38";
        inet = InetAddress.getByName(ipAddress);

        System.out.println("Sending Ping Request to " + ipAddress);
        System.out.println(inet.isReachable(5000) ? "Host is reachable" : "Host is NOT reachable");
    }
}
