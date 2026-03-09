import java.util.Scanner;

abstract class Employee{
    private String name;
    private double salary;

    Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public double getSalary(){
        return salary;
    }

    public abstract String getInfo();
    public abstract double calculateSalary();
}

class FullTimeEmployee extends Employee{
    private double bonus;

    public FullTimeEmployee(String name, double salary, double bonus){
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    public String getInfo(){
        String s1 = "Loại: FullTime\n";
        String s2 = String.format("Họ tên: %s\n", getName());
        String s3 = String.format("Lương cơ bản: %.1f\n", getSalary());
        String s4 = String.format("Thưởng: %.1f\n", bonus);
        String s5 = String.format("=> Lương thực nhận: %.1f\n", calculateSalary());
        return s1 + s2 + s3 + s4 + s5;
    }

    @Override
    public double calculateSalary(){
        return getSalary() + bonus;
    }
}

class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int hoursWorked, double hourlyRate){
        super(name, 0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String getInfo(){
        String s1 = "Loại: PartTime\n";
        String s2 = String.format("Họ tên: %s\n", getName());
        String s3 = String.format("Số giờ làm việc: %d\n", hoursWorked);
        String s4 = String.format("Tiền công mỗi giờ: %.1f giờ\n", hourlyRate);
        String s5 = String.format("=> Lương thực nhận: %.1f\n", calculateSalary());
        return s1 + s2 + s3 + s4 + s5;
    }

    @Override
    public double calculateSalary(){
        return hoursWorked * hourlyRate;
    }
}

public class INHERITANCE012 {
    public static void main(String[] args){
        Scanner sc;
        sc = new Scanner(System.in);

        System.out.println("--- Thông tin nhân viên ---");

        for(int i = 1; i <= 2; i++){
            String type = sc.nextLine();
            String name = sc.nextLine();
            switch(type){
                case "FullTime":
                    double salary = sc.nextDouble();
                    double bonus = sc.nextDouble();
                    FullTimeEmployee ef = new FullTimeEmployee(name, salary, bonus);
                    System.out.println(ef.getInfo());
                    break;
                case "PartTime":
                    int hoursWorked = sc.nextInt();
                    double hourlyRate = sc.nextDouble();
                    PartTimeEmployee ep = new PartTimeEmployee(name, hoursWorked, hourlyRate);
                    System.out.println(ep.getInfo());
                    break;
            }
            sc.nextLine();
        }

        sc.close();
    }
}
