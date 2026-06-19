==================================== Instance Control Flow =========================
Whenever we are executing java class 1st static control flow will be executed. In the static block if we are creating an object the following -
1. Identification of instance members from top to bottom.
2. Execution of instance variable assignments & instance blocks from top to bottom.
3. Execution of constructor.

class Test {
	int i = 10;
	{
		m1();
		System.out.println("1st Instance Block");
	}
	Test() {
		System.out.println("Constructor");
	}
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println("Main");
	}
	public void m1() {
		System.out.println(j);
	}
	{
		System.out.println("2nd Instance Block");
	}
	int j = 20;
}

Output:
0
1st Instance Block
2nd Instance Block
Constructor
Main


Note: If we comment "Test t = new Test();" Output will be just: Main

==================================== Instance Control Flow =========================

==================================== Instance Control Flow From Parent to Child Relationship =========================
1. Identification of instance members from Parent to Child
2. Execution of instance variable assignments and instance blocks only in Parent class
3. Execution of Parent constructor
4. Execution of instance variable assignments and instance blocks in Child class
5. Execution of Child constructor

class Parent {
	int i = 10;
	{
		m1();
		System.out.println("Parent Instance Block");
	}
	Parent() {
		System.out.println("Parent Constructor");
	}
	public static void main(String[] args) {
		Parent p = new Parent();
		System.out.println("Parent Main");
	}
	public void m1() {
		System.out.println(j);
	}
	int j = 20;
}

class Child extends Parent {
	int x = 100;
	{
		m2();
		System.out.println("1st Child Instance Block");
	}
	child() {
		System.out.println("Child Constructor");
	}
	public static void main(String[] args) {
		C c = new C();
		System.out.println("Child Main");
	}
	public void m2() {
		System.out.println(y);
	}
	{
		System.out.println("2nd Child Instance Block");
	}
	int y = 200;
}


