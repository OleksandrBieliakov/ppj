package ppj.werner.e10.p1;

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
	
	public double getDiagonal() {
		return Math.sqrt(2*side*side);
	}
	
	public double getPerimeter() {
		return 4*side;
	}
	
}