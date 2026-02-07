import java.util.Scanner;

class Point{
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
    public void move(int dx, int dy){
        x += dx;
        y += dy;
    }
    public double distanceTo(Point p){
        int x1 = this.x;
        int y1 = this.y;
        int x2 = p.x;
        int y2 = p.y;
        return Math.sqrt((x1-x2) * (x1-x2) + (y1-y2) * (y1-y2));
    }
}

public class OOP004 {
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            Point A = new Point();
            int xA = sc.nextInt();
            A.setX(xA);
            int yA = sc.nextInt();
            A.setY(yA);
            A.move(1, 1);

            Point B = new Point();
            int xB = sc.nextInt();
            B.setX(xB);
            int yB = sc.nextInt();
            B.setY(yB);

            System.out.printf("%.2f\n", A.distanceTo(B));
        }
        sc.close();
    }
}
