==================================== Static Block =========================
1. Static blocks will be executed at the time of class loading, hence at the time of class loading if we want to perform any activity we have to define that inside static block.

(a) At the time of java class loading the corresponding native libraries should be loaded, hence we have to define this activity inside static block.

Static Block - Once per class loading
Constructor - Once per object creation

class Calculator {
	static {
		System.out.println("Loading Library");
		System.loadLibrary("calculator");
	}
	
	Calculator() {
		System.out.println("Constructor Called");
	}
}

public class Main {
	public static void main(String[] args) {
		new Calculator();
		new Calculator();
		new Calculator();
	}
}

(b) After loading every database driver class we have to register driver class with driver manager, but inside database driver class there is a static block to perform this activity
and we are not responsible to register explicity.
(c) System.exit(0); - not necessary to have a main method.