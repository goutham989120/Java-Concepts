===================================== Synchronized Block ================================
If very few lines of the code required synchronization then it is not recommended to declare entrie method as synchronized, we have to enclose those few line by using synchronized block.

Reduces the waiting time of threads and improves the performace of the system.

A synchronized block allows you to synchronize only a specific portion of code instead of the entire method.
synchronized(lockObject) {
    // Critical section
}

A synchronized block allows only a specific section of code to be executed by one thread at a time using a particular lock object. It provides finer-grained locking compared to synchronized methods, reduces contention, and generally offers better performance because non-critical code can still execute concurrently.

We can declare synchronized block as follows -
1. To get lock of current object - synchronized(this)
2. To get lock of specific object - synchronized(b)
3. To get lock of class level lock - synchronized(Display.class)

class Display {
	public void wish(String name) {
		;;;;;;;;;;;;;;;; // 1 lakh lines of code
		synchronized(this) { // synchronized(Display.class) - for class-level lock
			for(int i = 0; i < 10; i++) {
				System.out.println("Good morning");
				try {
					Thread.sleep(2000);
				} catch(InterruptedException e) {
				}
					System.out.println(name);
				}
		}
		;;;;;;;;;; // 1 lakh lines of code
	}
}

class MyThread extends Thread {
	Display d;
	String name;
	MyThread(Display d, String name) {
		this.d = d;
		this.name = name;
	}
	public void run() {
		d.wish(name);
	}
}
class SynchronizedDemo {
	public static void main(String[] args) {
		Display d = new Display();
		MyThread t1 = new MyThread(d,"Mark");
		MyThread t2 = new MyThread(d,"Antony");
		
		t1.start();
		t2.start();
	}
}

Lock concept applicable object types and class type but not for primitives , hence we can't pass primitive type argument to synchronized block, otherwise we will get compile time error - Unexpected type found : int required ; reference

If multiple threads operating simultaneously on same Java object then there may be a chance of data inconsistency problem - "Race Condition". We can overcome this problem by using synchronized keyword.