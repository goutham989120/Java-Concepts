=============================== Coupling =========================
The degree of dependency between two classes/components is called coupling.
If dependency is more - tightly coupling and if dependency is less - loosely coupling

Coupling is the degree of dependency between classes. If changes in one class heavily affect another class, the classes are tightly coupled. If classes interact through abstractions
such as interfaces, they are loosely coupled. Modern Java applications prefer loose coupling because it improves flexibility, maintainability, and testability.

1. Tight Coupling -
	A class directly creates and depends on another class.
	
	class A {
		static int i = B.j;
	}
	class B {
		static int j = C.k;
	}
	class C {
		static int k = D.m1();
	}
	class D {
		public static int m1() {
			return 10;
		}
	}
	
		a. Ehancement difficult
		b. Code reusability issues
		c. Maintainability issues
	
class Engine {
	void start() {
		System.out.println("Engine Started");
	}
}

class Car {
	private Engine engine = new Engine(); // Changes in Engine may affect Car 
	void startCar() {
		engine.start();
	}
}

public class Main {
	public static void main(String[] args) {
		
		Car c = new Car();
		c.startCar();
	}
}

2. Loose Coupling - Use abstraction(interface) and inject the dependency.

interface Engine {
	void start();
}

class PetrolEngine implements Engine {
	public void start() {
		System.out.println("Petrol Engine Started");
	}
}

class ElectricEngine implements Engine {
	public void start() {
		System.out.println("Electric Engine Started");
	}
}

class Car {
	private Engine engine;
	public Car(Engine engine) {
		this.engine = engine;
	}
	void startCar() {
		engine.start();
	}
}

piblic class Main {
	public static void main(String[] args) {
		Engine engine = new ElectricEngine();
		Car car = new Car(engine);
		car.startCar();
	}
}
Measures dependency within a class.
=============================== Coupling =========================
=============================== Cohesion =========================
Measures dependency between the classes
How closely related the responsibilities of a class are. Cohesion measures whether a class is doing one specific job or many unrelated jobs.
Cohesion is the degree to which the methods and data within a class are related to each other and work together to perform a single well-defined responsibility.
Aim for :
Low Coupling
High Cohesion
=============================== Cohesion =========================
=============================== Type Casting =====================
Object o = new String("India");
Runnable r = new Thread();
Runnable - interface & Thread is it's implemented class

A b = (C) d;
A - Class/Interface name
b - Name of reference variable 
C - Class/Interface name
d - reference variable name

(C) d - converting d object to C type

1. Compile time checking 1 - The type of 'd' and 'C' must have some relation either child to parent or parent to child are same type. Otherwise we will get compile time error.

Valid:
Object o = new String("Durga");
StringBuffer sb = (StringBuffer) o;

Invalid:
Object o = new String("India");
StringBuffer sb = (String) o;

2. Compile time checking 2 - 'C' must be either same or derived type of 'A' otherwise we will get compile time error saying incompatible type found : C required : A 

Valid:
Object o = new String("Durga");
StringBuffer sb = (StringBuffer) o;

Invalid:
Object o = new String("India");
StringBuffer sb = (String) o;

CE: incompatible types
found : java.lang.String
required : java.lang.StringBuffer

3. Runtime checking - Runtime object type of 'd' must be either same or derived type of 'C' otherwise we will get runtime exception with 'ClassCastException'.

Invalid:
Object o = new String("India");
StringBuffer sb = (StringBuffer) o;
RE: ClassCastException : java.lang.String cannot be cast to java.lang.StringBuffer

Valid:
Object o = new String("India");
Object o1  = (String) o;

=============================== Type Casting =====================

