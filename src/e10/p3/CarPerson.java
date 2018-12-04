package e10.p3;

public class CarPerson {
	
	public static void main (String[] args) {
		
		Car[] car = {new Car("Honda 91", 5000), new Car("Toyota X", 12000),
					new Car("BMW Z1", 10000), new Car("Kia broke", 3000)};
		
		Person[] person = {new Person("Vasya", car[0]), new Person("Petja", car[1]),
						new Person("Masha", car[2]), new Person("Sasha", car[3])};

		Car[] carPerson = Person.getCars(person);

		for (Car s : carPerson)
			System.out.println(s);

		System.out.println();

		Car[] expCars = Person.expensiveCars(person, 9000);

		for (Car s : expCars)
			System.out.println(s);

	}
	
}
