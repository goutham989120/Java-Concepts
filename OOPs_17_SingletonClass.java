============================= Singleton Class ============================
A Singleton Class is a class for which only one object can be created throughout the application.
Ex: Runtime
Business Delegate
ServiceLocator

Advantage of Singleton class -

If several people have same requirement then it is not recommended to create a seperate object for every requirement.
We have to create only one object and we can reuse the same object for every similar requirement so that performance and memory utilization will be improved.

To make sure only one object is created, we do three things:
Step 1: Make constructor private
private Singleton() {
}
Now nobody can do:
new Singleton(); // ❌ Not allowed 

Step 2: Create one object inside the class
private static Singleton instance = new Singleton();

Step 3: Provide a public method to access it
public static Singleton getInstance() {
    return instance;
}

Complete Example
class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton() {
        System.out.println("Object Created");
    }

    public static Singleton getInstance() {
        return instance;
    }
}

public class Main {

    public static void main(String[] args) {

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1);
        System.out.println(s2);
    }
}

Output:
Object Created
Singleton@123
Singleton@123

Approach 1:
We can create our own singleton class - we need to use private constructor, private static variable and public factory method.
class Test {
	private static Test t = new Test();
	private Test() {
	}
	public static Test getTest() {
		return t;
	}
};

Test t1 = Test.getTest();
Test t2 = Test.getTest();
Test t3 = Test.getTest();
.
.
Test t100 = Test.getTest();

Approach 2:
class Test {
	private static Test t = null;
	private Test() {
	}
	public static Test getTest() {
		if(t == null) {
			t = new Test();
		}
		return t;
	}
}

* Class is not final, but we are not allowed to create child classes - how ?

By declaring every constructor as "private" we can restrict child class creation.

class P {
 private P() {
 }
}

For the above class it's impossible to create child class. 