import java.util.*;
import java.io.*;

class OverheatException extends Exception{
    public OverheatException(String msg){
        super(msg);
    }
}

class Reactor{
    private double temperature;
    
    public Reactor(double temperature){
        this.temperature = temperature;
    }
    
    public void increaseTemperature(double amount) throws OverheatException{
        if(amount <= 0){
            throw new IllegalArgumentException("");
        }
        if(temperature + amount > 1000){
            throw new OverheatException("");
        }
        temperature += amount;
        System.out.printf("Nhiệt độ hiện tại: %.1fđộ C\n", temperature);
    }
}

public class EXCEPTION007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double temp = Double.parseDouble(sc.nextLine());
        Reactor reactor = new Reactor(temp);
        while(sc.hasNextLine()){
            String input = sc.nextLine();
            try{
                double amount = Double.parseDouble(input);
				reactor.increaseTemperature(amount);
            }
            catch(NumberFormatException e){
                System.out.printf("Nhập: %s => Lỗi: Định dạng không hợp lệ.\n", input);
            }
            catch(IllegalArgumentException e){
                System.out.printf("Nhập: %s => Lỗi: Giá trị tăng phải lớn hơn 0.\n", input);
            }
            catch(OverheatException e){
                System.out.printf("Nhập: %s => Lỗi: Vượt quá ngưỡng an toàn! Nhiệt độ nguy hiểm.\n", input);
            }
        }
    }
}
