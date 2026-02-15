import java.util.Scanner;

public class STRING007 {
    public static boolean isPangram(String s){
        boolean[] visited = new boolean[26];
        int cnt = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= 'a' && c <= 'z'){
                if(!visited[c-'a']){
                    visited[c-'a'] = true;
                    cnt++;
                }
            }
        }
        return cnt == 26;
    }
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String s = sc.nextLine();
            System.out.println(isPangram(s));
        }
        sc.close();
    }
}
