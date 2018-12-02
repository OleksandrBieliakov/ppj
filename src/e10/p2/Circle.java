package e10.p2;

import e10.p1.Square;

public class Circle {
	
	private int radius;
	
	public Circle(int r) {
		radius = r;
	}
	
	public double getRadius() {
		return side;
	}
	
	public double getArea() {
		return Math.PI*radius*radius;
	}

	public double getPerimeter() {
		return 2*Math.PI*radius;
	}
	
	public double getInscribedSquare() {
		return Square sq = new Square(radius*Math.sqrt(2));
	}
	
	public double getCircumscribedSquare() {
		return Square sq = new Square(2*radius);
	}
	
	@Override
	public String toString() {
		return;
	}
	
}