package ppj.werner.e10.p2;

public class Circle {

	private double radius;

	public Circle(double r) {
		radius = r;
	}

	public double getRadius() {
		return radius;
	}

	public double getArea() {
		return Math.PI*radius*radius;
	}

	public double getPerimeter() {
		return 2*Math.PI*radius;
	}

	public Square getInscribedSquare() {
		Square sq = new Square(radius*Math.sqrt(2));
		return sq;
	}

	public Square getCircumscribedSquare() {
		Square sq = new Square(2*radius);
		return sq;
	}

	@Override
	public String toString() {
		return "Circle[" + radius + "]";
	}

	public Circle(Square square) {
		this(Math.sqrt(square.getArea()/Math.PI));
	}

	public static Square[] getSquares(Circle[] arr) {
		Square[] squares = new Square[arr.length];
		for(int i = 0; i < squares.length; ++i) {
			squares[i] = new Square(Math.sqrt(arr[i].getArea()));
		}
		return squares;
	}

}