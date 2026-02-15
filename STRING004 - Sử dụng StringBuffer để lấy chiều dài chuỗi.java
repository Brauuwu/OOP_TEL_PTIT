import java.util.Scanner;

public class STRING004 {
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            System.out.println(sc.nextLine().length());
        }
        sc.close();
    }
}
