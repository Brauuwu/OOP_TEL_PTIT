import java.util.*;

public class Main {
    static class Final {
        static void f(boolean[] a, String[] b, Integer c) {
            System.out.println(b[0]);
            a[0] = true;
            c = c + 1;
            System.out.println(a[0]);
            System.out.println(c);
        }
        static void f(int d, char e, StringBuffer f) {
            System.out.println(d);
            d = d + (int)e;
            System.out.println(f);
        }
        static void f(double g, byte i, Float h){
            g = g + h;
            System.out.println(i+g);
        }
    }
    public static void main(String[] args) {
        int a = 10;
        double b = 3.14;
        char c = 'c';
        String[] d = {"OOP", "2023"};
        Integer e = 1;
        boolean[] f = {false, true};
        StringBuffer g = new StringBuffer("Khoa Vien Thong");
        byte h = 20;
        Float i = 0.5f;

        // (*) Your code goes below
        Scanner sc = new Scanner(System.in);
        
        String x = sc.next();
        String y = sc.next();
        String z = sc.next();
        
        if(x.equals("f") && y.equals("d") && z.equals("e")){
            Final.f(f, d, e);
        }
        
        if(x.equals("a") && y.equals("c") && z.equals("g")){
            Final.f(a, c, g);
        }
        
        if(x.equals("b") && y.equals("h") && z.equals("i")){
            Final.f(b, h, i);
        }
    }
}
