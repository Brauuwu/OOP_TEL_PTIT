import java.util.Scanner;

public class STRING001 {
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String input = sc.nextLine();
            String[] w = input.split("\\s+");

            String s = w[0];
            int i = Integer.parseInt(w[1]);

            System.out.printf("The character at position %d is %s\n", i, s.charAt(i));
        }
        sc.close();
    }
}
