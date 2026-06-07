import java.util.*;
import java.io.*;

class MyMethods {
    public static void m(int x) {
        try {
            m2(x);
            System.out.println(1);
        }
        catch (ArithmeticException e) {
            System.out.println(3);
        }
        catch (Exception e) {
            System.out.println(2);
        }
    }

    public static void m2(int x) throws IOException {
        System.out.println(4);
        if (x == 1)
            throw new IOException();
        if (x == 0)
            throw new ArithmeticException();
        System.out.println(5);
    }
}

public class EXCEPTION009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if(x == 0) MyMethods.m(1);
        if(x == 1) MyMethods.m(0);
        if(x == 2) MyMethods.m(2);
    }
}
