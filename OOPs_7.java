============================== Overriding w.r.t var-arg methods =======================
1. We can override var-arg method with another var-arg method only , if we are trying to override with normal method then it will become overloading but not overriding.

Overloading - same method signature but different parameters
overriding - same method signature and same parameters

class P {
	public void m1(int... x) {
		System.out.println("Parent");
	}
}

class C extends P {
	public void m1(int x) {
		System.out.println("Child");
	}
}

class Test {
	public static void main(String[] args) {
		P p = new P();
		p1.m1(10); // Parent
		
		C c = new C();
		c.m1(10); // Child
		
		P p1 = new C();
		p1.m1(10); // Parent
	}
}

============================== Overriding w.r.t var-arg methods =======================
============================== Overriding w.r.t variables =============================
2. Variables resolution always takes care by compiler based on reference type. Irrespective of whether variable is static or non-static.
Overriding applicable only for methods but not for variables.

class P {
	int x = 888;
}

class C extends P {
	int x = 999;
}

class Test {
	public static void main(String[] args) {
		P p = new P();
		System.out.println(p.x); // 888
		
		C c = new C();
		System.out.println(c.x); // 999
		
		P p1 = new C();
		System.out.println(p1.x); // 888
	}
}


Property - 
1. Method names - must be same(Overloading/Overriding)
2. Argument types - must be different(Overloading); must be same(Overriding)
3. Method signatures - must be different(Overloading); must be same(Overriding)
4. Return types - No restrictions(Overloading); must be same until 1.4v from 1.5v co-variant return types are allowed(Overriding)
5. Private, static, final methods - can be overloaded; cannot be overridden
6. Access modifiers - No restrictions(Overloading); The scope of access modifiers cannot be reduced(Overriding)
7. throws clause - No restrictions(Overloading); If child class method throws any checked exception compulsory parent class method should throw the same checked exceptionor it's parent.
8. Method resolution - Always takes care by compiler based on reference type(Overloading); Always takes care by JVM based on runtime object.
9. Compile Time/Static Polymorphism/early binding (Overloading); Run Time/Dynamic Polymorphism/late binding(Overriding) 

