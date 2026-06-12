========================= Is-A Relationship/Inheritance =====================
An Is-A Relationship means one class is a specialized version of another class.
Achieved by extends keyword and Code resuability
A java class cannot extend more than one class at a time hence Java doesn't support multiple inheritance in class.

But interface can extends any number of interfaces simultaneously, hence java provide support for multiple inheritance w.r.t interfaces
Ex. interface C extends A,B 

"Every class in java is child class of Object"

class Employee { // Parent class
	void work() {
		System.out.println("Employee is working");
	}
}

class Manager extends Employee { // Child class
	void manageTeam() {
		System.out.println("Manager is managing team");
	}
}

public class Main {
	public static void main(String[] args) {
		Manager mgr = new Manager();
		mgr.work();
		mgr.manageTeam();
		
		Employee emp = new Employee();
		emp.manageTeam(); // Error - on parent reference we cannot access child method
		
		Employee e = new Manager(); // Parent reference can be used to hold child object;
		e.work();
		e. manageTeam(); // Error - on parent reference we cannot access child method
		
	}
}



