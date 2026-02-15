import java.util.Scanner;

public class STRING009 {
    public static String stringSplosion(String s){
        String res = "";
        int n = s.length();
        for(int i = 1; i <= n; i++){
            String x = "";
            for(int j = 0; j < i; j++){
                x += s.charAt(j);
            }
            res += x;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String s = sc.nextLine();
            System.out.println(stringSplosion(s));
        }
        sc.close();
    }
}
