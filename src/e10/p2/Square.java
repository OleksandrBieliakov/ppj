package e10.p2;

public class Square {
	
	private int side;
	
	public Square(int side) {
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
	
	public double getInscribedCircle() {
		return Circle c = new Circle(side/2);
	}
	
	public double getCircumscribedCircle() {
		return Circle c = new Circle(Math.sqrt(2*side*side)/2);
	}
	
	@Override
	public String toString() {
		return;
	}
	
}