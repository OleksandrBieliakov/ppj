package ppj.e10.p3;

public class Person {
	
	private String name;
	private Car car;
	
	public Person(String name, Car car) {
		this.name = name;
		this.car = car;
	}
	
	public String getName() {
		return name;
	}
	
	public Car getCar() {
		return car;
	}
	
	@Override
	public String toString() {
		return "Person: " + name + " - " + car.getMake() + "(" + car.getPrice() + ")";
	}
	
	public static Car[] getCars(Person[] person){
		Car[] cars = new Car[person.length];
		for (int i = 0; i < cars.length; ++i) {
			cars[i] = person[i].getCar();
		}
		return cars;
	}

	public static Car[] expensiveCars(Person[] person, int price) {
		
		int count = 0;
		boolean[] isExp = new boolean[person.length];
	
		for(int i = 0; i < person.length; ++i) {
			if(person[i].getCar().getPrice() >= price) {
				++count;
				isExp[i] = true;
			}
		}

		if(count == 0) return null;

		Car[] eCars = new Car[count];
		int n = 0;

		for(int i = 0; i < isExp.length; ++i) {
			if(isExp[i]) eCars[n++] = person[i].getCar();
		}

		return eCars;

	}

}