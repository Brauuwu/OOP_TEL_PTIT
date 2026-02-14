import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DSA001 {
    public static void main(String[] args){
        Scanner sc;
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] a = new int[n];
            for(int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            Map<Integer, Integer> mp = new HashMap<>();
            int cnt = 0;

            for(int i = 0; i < n; i++){
                int x = k - a[i];
                if(mp.containsKey(x)) cnt += mp.get(x);
                mp.put(a[i], mp.getOrDefault(a[i], 0) + 1);
            }
            System.out.println(cnt);
        }
        sc.close();
    }
}
