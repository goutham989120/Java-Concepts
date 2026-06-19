======================================= Prototype of Default Constructor ================
1. Always no-arg constructor
2. Access modifier same as class modifier (public, default)
3. Only one line i.e., super();

// Program's code
class Test {

}

// Compiler's code
class Test {
	Test() {
		super();
	}
}

// Program's code
public class Test {
	
}

// Compiler's code
public class Test {
	public Test() {
		super();
	}
}

// Program's code
public class Test {
	void Test() {
	}
}

// Compiler's code
public class Test {
	public Test() {
		super();
	}
	void Test() {
	}
}

Case 1: We can take super(); or this(); only in first line of constructor, if we are trying to take anywhere else we will get compile-time error.

class Test {
	Test() {
		int i = 0;
		super();
	}
}
CE: call to super must be first statement in constructor.

Case 2: Within the constructor we can take either super() or this() but not both simultaneously.
class Test {
	Test() {
		super();
		this();
	}
}
CE: call to this must be first statement in constructor.

Case 3: We can use super() or this() only inside constructor, if we are trying to use ourside of constructor we will get compile-time error.
We can call a constructor directly from another constructor only. 
class Test {
	public void m1() {
		super();
		System.out.println("Hello");
	}
}

super(), this()
1. These are constructor calls to call super class and current class constructors
2. We can use only in constructors as 1st line
3. We can use only once in constructor

super, this
1. These are keywards to refer super class and current class instance members
2. We can use anywhere except static area
3. We can use any no. of times

class Employee {

    String name;
    double salary;

    Employee(String name, double salary) {

        this.name = name;
        this.salary = salary;
    }
}

public class Main {

    public static void main(String[] args) {

        Employee emp = new Employee("Mark", 50000);

        System.out.println(emp.name);
        System.out.println(emp.salary);
    }
}

======================================= Prototype of Default Constructor ================