package Functional;


import java.io.IOException;

public class Reboot {

    public static void Rebooting (String name) throws IOException {
        String cmdComand = ("shutdown -r -t 1 -m \\\\"+name);

        Process go = Runtime.getRuntime().exec(cmdComand);
    }
}
