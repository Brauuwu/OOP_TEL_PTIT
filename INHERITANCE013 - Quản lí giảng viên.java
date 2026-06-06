import java.util.*;

abstract class Teacher{
    protected String name;
    protected double baseSalary;
    
    public Teacher(String name, double baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
    }
    
    abstract public String getInfo();
    abstract public double calculateSalary();
}

class PermanentLecturer extends Teacher{
    private double researchAllowance;
    
    public PermanentLecturer(String name, double baseSalary, double researchAllowance){
        super(name, baseSalary);
        this.researchAllowance = researchAllowance;
    }
    
    @Override
    public double calculateSalary(){
        return baseSalary + researchAllowance;
    }
    
    public String getInfo(){
        String s1 = "Loại giảng viên: Permanent";
        String s2 = String.format("Họ tên: %s", name);
        String s3 = String.format("Lương thực nhận: %.1f", calculateSalary());
        return s1 + "\n" + s2 + "\n" + s3;
    }
}

class VisitingLecturer extends Teacher{
    private int teachingHours;
    private double paymentPerHour;
    
    public VisitingLecturer(String name, int teachingHours, double paymentPerHour){
        super(name, 0);
        this.teachingHours = teachingHours;
        this.paymentPerHour = paymentPerHour;
    }
    
    @Override
    public double calculateSalary(){
        return teachingHours * paymentPerHour;
    }
    
    @Override
    public String getInfo(){
        String s1 = "Loại giảng viên: Visiting";
        String s2 = String.format("Họ tên: %s", name);
        String s3 = String.format("Lương thực nhận: %.1f", calculateSalary());
        return s1 + "\n" + s2 + "\n" + s3;
    }
}

public class INHERITANCE013{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Thông tin giảng viên ---");
        for(int i = 1; i <= 2; i++){
            String teacher = sc.nextLine();
            switch(teacher){
                case "PermanentLecturer":
                    PermanentLecturer pl = new PermanentLecturer(sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
                    System.out.println(pl.getInfo());
                    break;
                case "VisitingLecturer":
                    VisitingLecturer vl = new VisitingLecturer(sc.nextLine(), Integer.parseInt(sc.nextLine()), Double.parseDouble(sc.nextLine()));
                    System.out.println(vl.getInfo());
                    break;
            }
        }
    }
}
