import java.util.Scanner;

public class BASIC005 {
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int[] num = new int[5];
            int sum = 0;
            for(int i = 0; i< num.length; i++){
                num[i] = sc.nextInt();
                sum += num[i];
            }
            System.out.println(sum);
        }
        sc.close();
    }
}
