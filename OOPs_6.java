================================ Overriding - Static methods ==============================
1. Parent Static method and child non-static method - we can't override a static method as non-static 

class P {
	public static void m1() {
	}
}

class C extends P {
	public void m1() {
	}
}

2. We cannot override a non-static method as static

class P {
	public void m1() {
	}
}

class C extends P {
	public static void m1() {
	}
}

3. If both are static methods - it's method hiding not overriding.

class P {
	public static void m1() {
	}
}

class C extends P {
	public static void m1() {
	}
}

4. In method hiding - method resolution always handled/takes care by JVM  based on compiler reference.