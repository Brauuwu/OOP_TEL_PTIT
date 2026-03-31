import java.util.Scanner;

class Amount{
    private String currency;
    private int amount;

    public Amount(String currency, int amount){
        this.currency = currency;
        this.amount = amount;
    }

    public int add(Amount other) throws Exception{
        if(!this.currency.equals(other.currency)){
            throw new Exception("Currency doesn't match");
        }
        return this.amount + other.amount;
    }
}

public class EXCEPTION001 {
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            try{
                String input = sc.nextLine();
                String[] s = input.split("\\s+");

                Amount amount1 = new Amount(s[0], Integer.parseInt(s[1]));
                Amount amount2 = new Amount(s[2], Integer.parseInt(s[3]));

                System.out.println(amount1.add(amount2));
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}
