import java.util.Scanner;

public class STRING004 {
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String s = sc.nextLine();
            StringBuffer ns = new StringBuffer(s);
            System.out.println(ns.length());
        }
        sc.close();
    }
}
