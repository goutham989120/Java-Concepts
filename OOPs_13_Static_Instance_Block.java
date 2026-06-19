======================== Both Static & Instance ====================
class Test {
	{
		System.out.println("1st Instance Block");
	}
	static {
		System.out.println("1st Static Block");
	}
	Test() {
		System.out.println("Constructor");
	}
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println("Main");
		Test t1 = new Test();
	}
	static {
		System.out.printl("2nd Static Block");
	}
	{
		System.out.println("2nd Instance Block");
	}
}

Output:
1st Static Block
2nd Static Block
1st Instance Block
2nd Instance Block
Constructor
Main
1st Instance Block
2nd Instance Block
Constructor

public class Initialization {
	private static String m1(String msg) {
		System.out.println(msg);
		return msg;
	}
	public Initialization() {
		m = m1("1");
	}
	{
		m = m1("2");
	}
	String m = m1("3");
	public static void main(String[] args) {
		Object o = new Initialization();
	}
}

Output:
2
3
1

public class Initialization {
	private static String m1(String msg) {
		System.out.println(msg);
		return msg;
	}
	static String m = m1("1");
	{
		m = m1("2");
	}
	static {
		m = m1("3");
	}
	public static void main(String[] args) {
		Object obj = new Initialization();
	}
}

Output:
1
3
2

Note: From static area we can't access instance members directly because while executing static area JVM may not identify instance members.
class Test {
	int x = 10;
	public static void main(String[] args) {
		System.out.println(x);
	}
}

But - Test t = new Test();
System.out.println(t.x);
CE: non-static variable 'x' cannot be referenced from a static context

========================= How many ways we can create an object in or to get object in Java ==================================
N  → New
R  → Reflection : Reflection allows frameworks to create objects and invoke methods without knowing the classes at compile time.
The framework doesn't know your class names at compile time. It discovers them at runtime and creates objects dynamically using Reflection.
C  → Clone
D  → Deserialization
F  → Factory Method

1. By using new operator 
	Test t = new Test();
2. By using newInstance()method
	Test t = (Test)Class .forName("Test").newInstance();
	
@Service
public class EmployeeService {
    public void display() {
        System.out.println("Hello");
    }
}
@RestController
public class EmployeeController {
    private final EmployeeService service;
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
}

You never write:

EmployeeService service = new EmployeeService();
EmployeeController controller = new EmployeeController(service);

Internally Spring does something like:

Class<?> cls = Class.forName("com.example.EmployeeService");
Object obj = cls.getDeclaredConstructor().newInstance();

Similarly:

Class<?> cls = Class.forName("com.example.EmployeeController");
Constructor<?> c = cls.getDeclaredConstructor(EmployeeService.class);
Object controller = c.newInstance(service);

1. Spring Boot
Annotations
      ↓
Reflection
      ↓
Bean Creation
      ↓
Dependency Injection		

2. Hibernate
Database Row
      ↓
Reflection
      ↓
Entity Object

3. JUnit
@Test Methods
      ↓
Reflection
      ↓
Create Object
      ↓
Invoke Methods

Object obj = cls.getDeclaredConstructor().newInstance(); is equivalent to new EmployeeService();

Constructor<?> c = EmployeeController.class.getDeclaredConstructor(EmployeeService.class); is equivalent to new EmployeeController(service);

Object controller =
        c.newInstance(service);
	
3. By using clone() method
	Test t = new Test();
	Test t1 = (Test)t.clone();
4. By using Deserialization
	FileInputStream fis = new FileInputStream("fileName.ser");
	ObjectInputStream ois = new ObjectInputStream(fis);
	Dog d2 = (Dog)ois.readObject();
5. By using Factory Method
	Runtime r = Runtime.getRuntime();

	