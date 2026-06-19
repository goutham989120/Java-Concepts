======================================= Static Control Flow =====================================
1. Static Control Block
(a) Identification of static members from top to bottom [1-6]
static int i & i = 0;[RIWO]
static int j & j = 0;[RIWO]
(b) Execution of static variable assignments and static blocks from top to bottom [7 to 12]
i = 10;[R&W]
j = 20;[R&W]
(c) Execution of main method [13 to 15]

class Base {
	// 1.
	static int i = 10; // 7.
	// 2.
	static {
		m1(); // 8.
		System.out.println("First Static Block"); // 10.
	}
	// 3.
	public static void main(String[] args) { 
		m1(); // 13
		System.out.println("Main Method"); // 15.
	}
	// 4.
	public static void m1() {
		System.out.println(j); // 9.
	}
	// 5.
	static {
		System.out.println("Second Static Block"); // 11.
	}
	// 6.
	static int j = 20; // 12. // 14.
}

Output :
0
First State Block
Second Static Block
20
Main Method

Direct Read(Read a variable inside static block) & Indirect Read(Calling a method and read a variable within method)

An Illegal Forward Reference occurs when you try to directly access a static variable before it is declared in the class.
You are referring to a variable before Java has seen its declaration.

If a variable is just identified by the JVM and original value not yet assigned, then the variable is said to be in RIWO state.
If a variabe is in RIWO state then we can't perform direct read , but we can perform indirect read.
If we are trying to read directly then we will get CE: Illegal Forward Reference.

class Test {
	static {
		System.out.println(x);
	}
	static int x = 10;
	public static void main(String[] args) {
	}
}

======================================= Static Control Flow =====================================