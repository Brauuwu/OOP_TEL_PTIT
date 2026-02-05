import java.util.ArrayList;
import java.util.Scanner;

public class BASIC011 {
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String str = sc.nextLine();
            String[] s = str.split("\\s+");
            ArrayList<Integer> a = new ArrayList<>();
            for(int i=0; i < s.length; i++){
                a.add(Integer.parseInt(s[i]));
            }
            if(a.size() < 2){
                System.out.println(0);
                continue;
            }
            int res = (int) 1e9;
            for(int i=0; i<s.length-1; i++){
                res = Math.min(res, a.get(i+1) - a.get(i));
            }
            System.out.println(res);
        }
        sc.close();
    }
}
