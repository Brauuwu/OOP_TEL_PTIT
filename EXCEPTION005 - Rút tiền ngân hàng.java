import java.util.Scanner;

class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String message){
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double balance){
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException{
        if(amount < 0){
            throw new IllegalArgumentException("Lỗi: Số tiền rút không được âm!");
        }
        if(amount > balance){
            throw new InsufficientFundsException("Lỗi: Số dư không đủ để rút " + amount);
        }
        balance -= amount;
        System.out.println("Rút tiền thành công! Số dư còn lại: " + balance);
    }
}

public class EXCEPTION005 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            double initialBalance = 0;
            try{
                initialBalance = Double.parseDouble(sc.nextLine());
            }
            catch(NumberFormatException e){
                System.out.println("Số dư không hợp lệ!");
                return;
            }

            BankAccount account = new BankAccount(initialBalance);

            while(sc.hasNextLine()){
                String line = sc.nextLine().trim();
                if(line.isEmpty()) break;

                double amount;
                try{
                    amount = Double.parseDouble(line);
                    account.withdraw(amount);
                }
                catch (NumberFormatException e) {
                    System.out.println("Lỗi: Vui lòng nhập số hợp lệ!");
                }
                catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                catch (InsufficientFundsException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        sc.close();
    }
}