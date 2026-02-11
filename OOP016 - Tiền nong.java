class Money{
    private int euros;
    private int cent;

    public Money(int euros, int cent){
        this.euros = euros;
        this.cent = cent;
    }

    public String toString(){
        String s = String.format("%d.%02de", euros, cent);
        return s;
    }

    private int toCent(){
        return euros * 100 + cent;
    }

    private Money fromCent(int totalCent){
        int new_euros = totalCent / 100;
        int new_cent = totalCent % 100;
        return new Money(new_euros, new_cent);
    }

    public Money plus(Money added){
        int totalCent = this.toCent() + added.toCent();
        return fromCent(totalCent);
    }

    public boolean lessThan(Money compared){
        return this.toCent() < compared.toCent();
    }

    public Money minus(Money minus){
        int totalCent = this.toCent() - minus.toCent();
        if(totalCent < 0) totalCent = 0;
        return fromCent(totalCent);
    }
}

public class OOP16 {
    public static void main(String[] args){
        Money a = new Money(10, 8);
        Money b = new Money(5, 5);
        Money c = a.plus(b);
        System.out.printf("%s\n%s\n%s\n", a, b, c);

        Money u = new Money(10, 0);
        Money y = new Money(3, 0);
        Money w = new Money(5, 0);
        System.out.println(u.lessThan(y));
        System.out.println(y.lessThan(w));

        Money m = new Money(10, 0);
        Money n = new Money(3, 50);
        Money o = m.minus(n);
        Money new_o = o.minus(m);

        System.err.printf("%s\n%s\n%s\n%s\n", m, n, o, new_o);
    }
}
