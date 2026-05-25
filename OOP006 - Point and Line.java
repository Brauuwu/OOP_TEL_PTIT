import java.util.*;

class Point {
	// Private variables
    private double x;
    private double y;
    private double z;
	// Constructor
    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
	// Public methods
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public boolean isSame(Point other) {
        return x == other.x && y == other.y && z == other.z;
    }

    public double distanceTo(Point other) {
        double dx = x - other.x;
        double dy = y - other.y;
        double dz = z - other.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}

class Line extends Point {
    private Point endPoint;
    public Line(Point startPoint, Point endPoint) {
        super(
            startPoint.getX(),
            startPoint.getY(),
            startPoint.getZ()
        );
        this.endPoint = endPoint;
    }

    public double getLength() {
        Point startPoint = new Point(
            getX(),
            getY(),
            getZ()
        );
        return startPoint.distanceTo(endPoint);
    }

    public boolean isSamePoint(){
        Point startPoint = new Point(
            getX(),
            getY(),
            getZ()
        );
        return startPoint.isSame(endPoint);
    }
}

public class OOP006 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> pointNames = new ArrayList<>();
        List<Point> pointList = new ArrayList<>();

        String startPointName = "";

        try {
            while (scanner.hasNextLine()) {
                String pointName = scanner.nextLine().trim();

                if (pointName.isEmpty()) {
                    continue;
                }

                if (!scanner.hasNextLine()) {
                    startPointName = pointName;
                    break;
                }

                String coordinateLine = scanner.nextLine().trim();
                String[] coordinates = coordinateLine.split("\\s+");

                if (coordinates.length != 3) {
                    System.out.println("invalid input");
                    return;
                }

                double x = Double.parseDouble(coordinates[0]);
                double y = Double.parseDouble(coordinates[1]);
                double z = Double.parseDouble(coordinates[2]);

                Point point = new Point(x, y, z);

                pointNames.add(pointName);
                pointList.add(point);
            }

            int startIndex = pointNames.indexOf(startPointName);

            if (startIndex == -1) {
                System.out.println("invalid input");
                return;
            }

            Point startPoint = pointList.get(startIndex);

            for (int i = 0; i < pointList.size(); i++) {

                if (i == startIndex) {
                    continue;
                }

                Point currentPoint = pointList.get(i);

                Line line = new Line(startPoint, currentPoint);

                System.out.print("Line " + startPointName + pointNames.get(i) + ": ");

                if (line.isSamePoint()) {
                    System.out.println("same point");
                } else {
                    System.out.printf("%.2f\n", line.getLength());
                }
            }
        }
        catch (Exception e) {
            System.out.println("invalid input");
        }
        finally {
            scanner.close();
        }
    }
}
