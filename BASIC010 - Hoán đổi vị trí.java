import java.util.Scanner;

public class BASIC010 {
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String n = sc.nextLine();
            int idx = 0;
            if(n.length() % 2 != 0) idx++;
            char s[] = n.toCharArray();
            for(int i = idx; i < n.length(); i+=2){
                char tmp = s[i];
                s[i] = s[i+1];
                s[i+1] = tmp;
            }
            String res = new String(s);
            System.out.println(res);
        }
        sc.close();
    }
}
