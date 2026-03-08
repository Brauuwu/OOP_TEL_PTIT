class SimpleDate{
    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay(){
        return day;
    }

    public int getMonth(){
        return month;
    }
    
    public int getYear(){
        return year;
    }

    @Override
    public boolean equals (Object obj){
        if(obj instanceof SimpleDate == false){
            return false;
        }
        
        SimpleDate sd1 = (SimpleDate)obj;

        return this.getDay() == sd1.getDay() && this.getMonth() == sd1.getMonth() && this.getYear() == this.getYear();
    }
}

public class Main {
    public static void main(String[] args){
        SimpleDate sd = new SimpleDate(1, 2, 2000);
        String s1 = "heh";
        SimpleDate sd2 = new SimpleDate(5, 2, 2012);
        SimpleDate sd3 = new SimpleDate(1, 2, 2000);
        System.out.printf("%b\n%b\n%b\n", sd.equals(s1), sd.equals(sd2), sd.equals(sd3));
    }
}
