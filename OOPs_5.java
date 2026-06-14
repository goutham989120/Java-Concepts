================================ Overriding ===========================
A child class provides its own implementation of a method that already exists in the parent class.
Achieved via - Runtime Polymorphism

In overriding method resolution always takes care by JVM based on runtime object and hence overriding is also considered as runtime/dynamic polymorphism / late binding.

Inheritance + Same Method Signature + Different Implementation = Method Overriding

// Parent Class
class Employee {
	void work() {
		System.out.println("Employee is working");
	}
}

class Developer extends Employee {
	@Override
	void work() {
		System.out.println("Developer is writing code");
	}
}

public class Main {
	public static void main(String[] args) {
		Developer dev = new Developer();
		dve.work();
	}
}

Rules -
(a) In overriding method names and argument types must me match i.e., method signatures must be same.
(b) Return type must be same untill (1.4v) after from (1.5v) - co-variant return types also allowed.
(c) Parent class private methods not available to the child and hence "overriding concept is not applicable for private methods".
(d) Based on our requirement we can define exactly same private method in child class it is valid, but not overriding.
(e) We can't override parent class final methods in child classes.
(f) Parent class abstarct methods , we should override in child class to provide implementation.
(g) We can override non-abstarct(parent class) methods as abstarcts

class P {
	public void m1() {
	}
	
	abstarct class C extends P {
		public abstract void m1();
	}
}
	Parent to Child
 (h) 1. final to non-final/final "Not possible"
	 2. non-final to final "Possible"
	 3. abstarct to non-abstarct "Possible"
	 4. synchronized to non-synchronized "Possible"
	 5. native to non-native "Possible"
	 6. strictfp to non-strictfp "Possible"
 (i) We cannot reduse scope of access modifier but we can increase the scope - Ex. public to default
 
 private < default < protected < public
 (j) If child class methods throws any checked exception, the parent class method should throw the same checked exception or it's parent.  
	
 