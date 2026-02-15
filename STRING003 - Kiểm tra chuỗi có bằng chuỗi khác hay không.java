import java.util.Scanner;

public class STRING003 {
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String s1 = sc.nextLine().toLowerCase();
            String s2 = sc.nextLine().toLowerCase();

            System.out.println(s1.equals(s2));
        }
        sc.close();
    }
}
