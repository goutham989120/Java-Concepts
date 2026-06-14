================= Data Hiding ======================
Process of restricting direct access to the internal data of a class and allowing access only through controlled methods.
Achieved via private access modifier on data.

class Employee {
	private String name;
	private double salary;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSalary(double salary) {
		if(salary > 0) {
			this.salary = salary;
		} else {
			System.out.println("Invalid salary");
		}
	}
	
	public double getSalary() {
		return salary;
	}
}
public class Main {
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setName("Mark");
		emp.setSalary(500000);
	}
}
	
===================== Absraction ====================================
Hinding implementation details and showing only the essential functionality to the user.
Achieved via - "Abstract class" and "Interface"
1. Abstract class -

Example without abstraction -

class EmailService {
	public void connectServer() {
		System.out.println("Connecting...");
	}
	public void authenticate() {
		System.out.println("Authenticating...");
	}
	public void sendData() {
		System.out.println("Sending email...");
	}
}

public static void main(String[] args) {
	EmailService email = new EmailService();
	email.connectServer();
	email.authenticate();
	email.sendData();
}

Example with abstraction -
class EmailService {
	public void sendEmail() {
		connectServer();
		authenticate();
		sendData();
	}
	
	public void connectServer() {
		System.out.println("Connecting...");
	}
	
	public void authenticate() {
		System.out.println("Authenticating...");
	}
	public void sendData() {
		System.out.println("Sending email...");
	}
}

public static void main(String[] args) {
	EmailService email = new EmailService();
	email.sendEmail();
}


1. Abstract Class
	abstract class Employee {
		abstract void calculateSalary(); // no implementation just declaration
	}
	
	class Manager extends Employee {
		@override
		void calculateSalary() {
			System.out.println("Manager salary = 1000000");
		}
	}
	
	class Developer extends Employee {
		@override
		void calculateSalary() {
			System.out.println("Developer salary = 500000");
		}
		
public class Main {
	public static void main(String[] args) {
		Employee emp1 = new Manager();
		Employee emp2 = new Developer();
		
		emp1.calculateSalary();
		emp2.calculateSalary();
	}
}

2. Interface

interface Payment {
	void pay(double amount);
}

class UpiPayment implements Payment {
	public void pay(double amount) {
		System.out.println("UPI Payment :" + amount);
	}
}

class cardPayment implements Payment {
	public void pay(double amount) {
		System.out.println("Card Payment: " + amount);
	}
}

public class Main {
	public static void main(String[] args) {
		Payment payment = new UpiPayment();
		payment.pay(500);
	}
}

Version			Feature					Impact on Abstraction
Java 1.0	Abstract Classes				Basic abstraction
Java 1.0		Interfaces					Contract-based abstraction
Java 5			Generics					Reusable abstractions
Java 8		Default Methods				Interfaces can have implementation
Java 8			Lambdas						Functional abstraction
Java 8		Static Interface Methods		Utility behavior in interfaces
Java 9		Private Interface Methods		Hide implementation in interfaces
Java 16			Records							Simplify data abstractions
Java 17		Sealed Classes					Controlled inheritance
Java 21		Pattern Matching			Cleaner handling of abstractions
Java 21		Record Patterns				Easy decomposition of abstract data

================================ Encapsulation ================================
Bundling data(variable) & methods (behavior) into a single unit (class) and controlling access to that data.
================================ Encapsulation ================================
================================ Tightly Encapsulated Class ===================
Is a class in which all data members (instance variables) are declared as private.
================================ Tightly Encapsulated Class ===================

