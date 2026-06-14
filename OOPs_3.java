=============================== Has-A Relationship ==============================
A Has-A Relationship represents composition or aggregation in Java, where one class contains a reference to another class as a member variable.
Achieved by either "Composition" or "Aggregation"

1. Composition - a strong association between contained and container objects. Without existing container object if there is no chance of contained objects.
The contained object cannot exist independently of the container object. Ex. - If the house is destroyed, the rooms are also considered destroyed.

class Engine {
	void start() {
		System.out.println("Engine Started");
	}
}

class Car {
	private Engine engine;
	
	public Car() {
		engine = new Engine();
	}
	public void startCar() {
		engine.start();
		System.out.println("Car started");
	}
}

public class Main {
	publi static void main(String[] args) {
		Car car = new Car();
		car.startCar();
	}
}

2. Aggregation - Without existing container object if there is a chance of existing contained objects then container and contained objects are weakly associated.
The contained object can exist independently of the container object. Ex. - Department HAS-A Professor, If the department closes: Professor still exists.

"Can the child object exist without the parent object?"
No → Composition (Car → Engine)
Yes → Aggregation (Employee → Address)


class Address {
	private String city;
	
	piblic Address(String city) {
		this.city = city;
	}
	public String getCity() {
		return city;
	}
}

class Employee {
	private String name;
	private Address address;
	
	public Employee(String name, Address address) {
		this.name = name;
		this.address = address;
	}
	
	public void display() {
		System.out.println(name);
		System.out.println(address.getCity());
	}
}

public class Main {
	public static void main(String[] args) {
		Address address = new Address("Bengaluru");
		Employee emp = new Employee("Mark", address);
		
		emp.display();
	}
}
===================================== Has-A Relationship =================================
===================================== Method Signature ===================================
A Method Signature consists of: Method Name + Parameter List. To resolve method calls.
===================================== Method Signature ===================================
===================================== Overloading ========================================
Having multiple methods with the same name but different method signatures (different parameters).
Java decides which method to call based on:
Number of parameters
Type of parameters
Order of parameters

This is an example of "Compile-Time Polymorphism".

Same Method Name + Different Parameters = Method Overloading

In "Overloading" - method resolution always takes care by compiler based on reference type. Therefore it is also called as - compile time / static polymorphism / early binding.

Runtime object won't play any roll.  

===================================== Overloading ========================================