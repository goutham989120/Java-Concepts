=============================== Type Casting =====================
1. Strictly speaking through tyep casting we are not creating new object instead we are providing another type of referece variable i.e., we are performing tupecasting but not 
object casting for the existing obj.

String s = new String("India");
Object o = (Object) s;

same as - Object o = new String("India");

Integer i = new Integer(10);
Number n = (Number)i;
Object o = (Object)n;

is same as - Object o = new Integer(10);

System.out.println(i == n) - true;

Ex:

P -----> m1(){}
|
|
|
C -----> m2(){}

C c = new C();
c.m1();
c.m2();
((P)c).m1(); ==> P p = new C(); & p.m1();
((P)c).m2(); ==> P p = new C(); & p.m2(); --> not correct

================
A ->
m1() {
	System.out.ptrintln("A");
}

B ->
m1() {
	System.out.println("B");
}

C -> 
m1() {
	System.out.println("C");
}

C c = new C();
c.m1(); -----------> C
((B)c).m1(); -----> B b = new C(); & b.m1(); -------------> C
((A)((B)c)).m1(); -----> B b = (B)c; & A a = (A)b; & a.m1(); ----------> C


A ->
static m1() {
	System.out.ptrintln("A");
}

B ->
static m1() {
	System.out.println("B");
}

static C -> 
m1() {
	System.out.println("C");
}

C c = new C();
c.m1(); -----------> C
((B)c).m1(); -----> B b = new C(); & b.m1(); -------------> B
((A)((B)c)).m1(); -----> B b = (B)c; & A a = (A)b; & a.m1(); ----------> A


A -----> int x = 777;
B -----> int x = 888;
C -----> int x = 999;

C c = new C();
System.out.println(c.x); -----------> 999
System.out.println((B(c)).x); -----------> 888
System.out.println((A((B)c)).x); -------------> 777
