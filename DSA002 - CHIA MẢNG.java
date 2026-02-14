import java.util.Arrays;
import java.util.Scanner;

public class DSA002 {
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] a = new int[n];
            int sum = 0;
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
                sum += a[i];
            }

            Arrays.sort(a);
            k = Math.min(k, n-k);

            int sumK = 0;
            for(int i=0; i<k; i++){
                sumK += a[i];
            }
            int res = sum - 2*sumK;
            System.out.println(res);
        }
        sc.close();
    }
}
