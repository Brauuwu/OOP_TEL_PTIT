import java.util.Scanner;

class Point2D{
    private int x;
    private int y;

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

    public void shift(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }

    public double distanceToOrigin(){
        return Math.sqrt(x * x + y * y);
    }
}

public class OOP015 {
    public static void main(String[] args){
        Scanner sc;
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            Point2D p = new Point2D();

            int x = sc.nextInt();
            p.setX(x);

            int y = sc.nextInt();
            p.setY(y);

            p.shift(5, -4);
            System.out.printf("%.4f\n", p.distanceToOrigin());
        }
        sc.close();
    }
}
