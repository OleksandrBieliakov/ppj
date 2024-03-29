package ppj.werner.e10.p2;

public class SquareCirc {

    public static void main (String[] args) {

        Square[] sqs = {new Square(2), new Square(1),
                new Square(3), new Square(2)};

        for (Square s : sqs)
            System.out.print(s + " ");

        System.out.print("\nAreas: ");
        for (Square s : sqs)
            System.out.print(s.getArea() + " ");

        System.out.print("\nPerimeters: ");
        for (Square s : sqs)
            System.out.print(s.getPerimeter() + " ");

        Circle[] crs = {new Circle(2), new Circle(1),
                new Circle(3), new Circle(2)};

        Square[] squares = Circle.getSquares(crs);
        System.out.println("\nPerimeters of squares from circles: ");
        for (Square s : squares)
            System.out.printf("%.2f ", s.getArea());

    }

}
