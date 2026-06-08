import java.util.*;
import java.io.*;

class Utils {
    public static void u(String s) {
        try {
            System.out.println(s);
            new Utils().z(s);

            try {
                System.out.println(Integer.parseInt(s) + 1);
            } catch (NumberFormatException e) {
                System.out.println(s.toUpperCase());
            }

        } catch (IOException e) {
            System.out.println(1);
        }
    }

    public static void z(String s) throws IOException {
        System.out.println(2);

        if (s.length() == 1)
            throw new IOException();

        System.out.println(3);
    }
}

public class EXCEPTION004{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(sc.hasNext()) Utils.u(sc.next());
        sc.close();
    }
}
