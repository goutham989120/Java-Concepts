=================================== Synchronization ==============================
Case Study -

class Display {
	public synchronized void wish(String name) {
		for(int i = 0; i < 10; i++) {
			System.out.println("Good Morning");
			try {
				Thread.sleep(2000);
			}
			catch(InterruptedException e) {
				System.out.println(name);
			}
		}
	}
}

class MyThread extends Thread {
	Display d;
	String name;
	
	MyThread(Dispaly d, String name) {
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
		Display d2 = new Display();
		MyThread t1 = new MyThread(d,"Mark");
		MyThread t2 = new MyThread(d2,"David");
		t1.start();
		t2.start();
	}
}

Class-level Lock : Every class in Java has a unique lock which is nothing but class-level lock.

If a thread wants to execute a static synchronized method then thread required class-level lock. Once thread got class-level lock, then it is allowed to execute any static synchronized method of that class. Once method execution completes automatically thread releases the lock.

In Java, there are two types of locks used with synchronized:

Object-Level Lock (Instance Lock)
Class-Level Lock (Static Lock)

An Object-Level Lock synchronizes access to a particular object instance using that object's monitor (this). Different objects have different locks and can execute synchronized methods concurrently. A Class-Level Lock synchronizes access using the class object's monitor (ClassName.class). Since there is only one class object in the JVM per class loader, all instances share the same lock and synchronized static methods execute one at a time across all objects.

While a thread executing static synchronized method the remaining threads are not allowed to execute any static synchronized method of that class simultaneously, but remaining threads are allowed to execute the following method simultaneously -
1. Normal static methods
2.synchronized instance methods
3, Normal instance methods

class Display {
	public synchronized void displayn() {
		for(int i = 0; i < n; i++) {
			System.out.println(i);
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
			}
		}
	}
	public synchronized void displayc() {
		for(int i = 65; i < 75; i++) {
			System.out.println((char)i);
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
			}
		}
	}
}
class MyThread1 extends Thread {
	Display d;
	MyThread1(Display d) {
		this.d=d;
	}
	public void run() {
		d.displayn();
	}
}
class MyThread2 extends Thread {
	Display d;
	MyThread2(Display d) {
		this.d=d;
	}
	public void run() {
		d.displayc();
	}
}
class SynchronizedDemo1 {
	public static void main(String[] args) {
		Display d = new Display();
		MyThread1 t1 = new MyThread1(d);
		MyThread2 t2 = new MyThread2(d);
		t1.start();
		t2.start();
	}
}
			