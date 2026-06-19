=============================== Overloaded Constructors ========================
Having multiple constructors in the same class with different parameter lists.

class Test {
	Test()
	{
		this(10);
		System.out.println("no-arg");
	}
	Test(int i) {
		this(10.5);
		System.out.println("int-arg");
	}
	Test(double d) {
		System.out.println("double-arg");
	}
	
	public static void main(String[] args) {
		Test t1 = new Test();
		Test t2 = new Test(10);
		Test t3 = new Test(10.5);
		Test t4 = new Test(10l); // automatic promotion
	}
}

Output:
double-arg
int-arg
no-arg

double-arg
int-arg

double-arg

double-arg

Conclusion:
1. For constructors inheritance and overriding concepts are not applicable, but overloading concept is applicable.
2. Every class in Java including abstarct class can contain constructor but "interface" cannot contain constructor.

Case 1: Recursive method call is runtime exception saying - stackoverflow error. In out program if there is a chance of recursive constructor invocation the code compile and we will get compile-time error.

class Test {
	public static void m1() {
		m2();
	}
	public static void m2() {
		m1();
	}
	public static void main(String[] args) {
		m1();
		System.out.println("Hello");
	}
}

Output: StackOverflowError

class Test {
	Test() {
		this(10);
	}
	Test(int i) {
		this();
	}
	public static void main(string[] args) {
		System.out.println("Hello");
	}
}

CE: Recursive Constructor invocation

Case 2:
// Valid
class P {
}
class C extends P {
}

// Valid
class P {
	P() {
	}
}

class C extends P {
}

// Invalid
class P {
	P(int i) {
	}
}
class C extends P {
}

CE: Cannot find symbol
symbol: Constructor P()
location: class P;

Case 3:
If parent class constructor any checked exception compulsory child class constructor should throw the same checked exception or it's parent otherwise the code won't compile. 


class P {
	P() throws IOException {
	}
}
class C extends P {
}

CE: Unreported exception java.io.IOException in default constructor

class P {
	P() throws IOException {
	}
}
class C extends P {
	C() throws IOExcpetion {
		super();
	}
}

=====================================================

class Employee {

    Employee() {
        System.out.println("No-Arg Constructor");
    }

    Employee(String name) {
        System.out.println("Name: " + name);
    }

    Employee(String name, double salary) {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

public class Main {

    public static void main(String[] args) {

        new Employee();

        new Employee("Mark");

        new Employee("John", 50000);
    }
}

Output:
No-Arg Constructor
Name: Mark
Name: John
Salary: 50000.0


class Employee {

    String name;
    double salary;

    Employee() {
        this("Unknown", 0);
    }

    Employee(String name) {
        this(name, 0);
    }

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println(name + " " + salary);
    }
}

public class Main {

    public static void main(String[] args) {

        Employee e1 = new Employee();
        Employee e2 = new Employee("Mark");
        Employee e3 = new Employee("John", 50000);

        e1.display();
        e2.display();
        e3.display();
    }
}

Output:
Unknown 0.0
Mark 0.0
John 50000.0