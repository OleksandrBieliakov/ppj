package ppj.e10.p2;

public class Square {

	private double side;

	public Square(double side) {
		this.side = side;
	}

	public double getSide() {
		return side;
	}

	public double getArea() {
		return side*side;
	}

	public double getPerimeter() {
		return 4*side;
	}

	public Circle getInscribedCircle() {
		Circle c = new Circle(side/2);
		return c;
	}

	public Circle getCircumscribedCircle() {
		Circle c = new Circle(Math.sqrt(2)*side/2);
		return c;
	}

	@Override
	public String toString() {
		return "Square[" + side + "]";
	}

	public Square(Circle circle) {
		side = Math.sqrt(circle.getArea());
	}

}