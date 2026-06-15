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
8. Method resolution - Always takes care by compiler based on reference type(Overloading); Always takes care by JVM based on runtime object(Overriding).
9. Compile Time/Static Polymorphism/early binding (Overloading); Run Time/Dynamic Polymorphism/late binding(Overriding)

==================================== Overriding w.r.t variables =============================
==================================== Polymorphism ===========================================
The same method call can behave differently depending on the object that executes it.
1. Method Overloading : Compile-Time Polymorphism
2. Method Overriding : Run-Time Polymorphism

class Payment {
	void pay() {
		System.out.println("Generic Payment");
	}
}

class UpiPayment extends Payment {
	@Override
	void pay() {
		System.out.println("UPI Payment");
	}
}

class CardPayment extends Payment {
	@Override
	void pay() {
		System.out.println("Card Payment");
	}
}

public class Main {
	public static void main(String[] args) {
		Payment payment = new UpiPayment();
		payment.pay();
		
		Payment payment = new CardPayment();
		payment.pay();
	}
}

Ex. Payment payment = new UpiPayment()
payment - Reference Type
UpiPayment - Actual Object

3. If we don't know exact run-time object then we should go for "parent reference".
Ex. The 1st element in the array list can be anytime - it may be "student/customer/string/StringBuffer object" hence the return type of get method is "Object" which can hold any object
Object o = l.get(0);

C c = new C(); - ArrayList al = new ArrayList(); - 
1. We can use this approach if we know exact run-time type of object
2. By using child reference we can call both parent and child class methods.
3. We can use child reference to hold only particular child class object.(Disadv)
P p = new C(); - List l = new ArrayList();
1. Use if we don't know exact run-time type of object.
2. By using parent reference only methods available in parent class and we can't call child specific methods.
3. We can use parent reference any child class object(Adv).

Encapsulation - Security
Polymorphism - Flexibility
Inheritance - Reusability

==================================== Polymorphism ===========================================

