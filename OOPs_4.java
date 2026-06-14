==================================== Overloading ========================================
(a) Automatic Promotion in Overloading -

Widening Primitive Conversions (or Automatic Type Promotion) in Java.
They show the order in which Java can automatically convert a smaller data type into a larger compatible data type without explicit casting.

char -> int -> long -> float -> double
byte -> short -> int -> long -> float -> double

class Test {
	public void m1(int i) {
		System.out.println("int-arg");
	}
	public void m1(float f) {
		System.out.println("float-arg");
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.m1(10);
		t.m1(10.5f);
		t.m1('a');
	}
}

(b) While resolving overload method - compiler will always give precedence for child type argument when compared with parent type argument.

(c) String and StringBuffer (null) - CE: Reference to m1() is ambiguous.

(d) m1(10, 10) : m1(int, float) & m1(float, int) - CE: Reference to m1() is ambiguous.
m1(10f, 10f) : m1(int, float) & m1(float, int) - CE: Cannot find symbol Symbol: method m1(float, float) location: class Test

(e) t.m1(10) : m1(int x)[Generic method] & m1(int... x)[var-arg method] - Generic method get chance

(f) In general var-agr method get least priority, if there is no other matched then only var-agr method get chance , same a switch case

==================================== Overloading ========================================