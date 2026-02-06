import java.util.Scanner;

public class BASIC002 {
    public static  int numMusicPlayists(int k, int n, int goal){
        int MOD = (int) 1e9+7;
        long[][] dp = new long[goal+1][n+1];
        dp[0][0] = 1;
        for(int i=1; i<=goal; i++){
            for(int j=1; j<=Math.min(i, n); j++){
                dp[i][j] = dp[i-1][j-1] * (n-j+1) % MOD;
                if(j > k) dp[i][j] = (dp[i][j] + dp[i-1][j] * (j-k)) % MOD;
            }
        }
        return (int) dp[goal][n];
    }

    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int k = sc.nextInt();
            int n = sc.nextInt();
            int goal = sc.nextInt();
            System.out.println(numMusicPlayists(k, n, goal));
        }
        sc.close();
    }
}
