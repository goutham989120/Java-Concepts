======================================== Deadlock ===============================================
Two or more threads are waiting for each other indefinitely, and none of them can proceed.
Synchronized keyword is the only reason for deadlock situation, hence while using synchronized keyword we have to take special care.
There are no resolution technique for deadlock but several prevention techniques are available.

class DeadlockDemo {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread-1 acquired lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                System.out.println(hread-1 waiting for lock2");
                synchronized (lock2) {
                    System.out.println("Thread-1 acquired lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread-2 acquired lock2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                System.out.println("Thread-2 waiting for lock1");
                synchronized (lock1) {
                    System.out.println("Thread-2 acquired lock1");
                }
            }
        });
        t1.start();
        t2.start();
    }
}

================================
class A {
	public synchronized void d1(B b) {
		System.out.println("Thread starts execution of d1()");
		try {
			Thread.sleep(2000);
		} catch(interruptedException e) {
		}
		System.out.println("Threads trying to call B's last() method");
		b.last();
	}
	public synchronized void last() {
		System.out.println("Inside A's last()");
	}
	
}

class B {
	public synchronized void d2(A a) {
		System.out.println("Thread starts execution of d2()");
		try {
			Thread.sleep(5000);
		} catch(interruptedException e) {
		}
		System.out.println("Threads trying to call A's last() method");
		a.last();
	}
	public synchronized void last() {
		System.out.println("Inside B's last()");
	}
	
}

class MyThread extends Thread {
	A a = new A();
	B b = new B();
	
	public void m1() {
		this.start();
		a.d1(b); // Main thread
	}
	
	public void run() {
		b.d2(a);
	}
	
	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.m1();
		
	}
}

In the above program if we remove atleast one synchronized keyword - the program will never enter into deadlock.

A deadlock occurs when two or more threads are blocked forever because each thread holds a resource and waits for another resource held by another thread. A common example is Thread-1 holding lock1 and waiting for lock2, while Thread-2 holds lock2 and waits for lock1. Deadlocks can be prevented by acquiring locks in a consistent order, minimizing lock duration, and using mechanisms like ReentrantLock.tryLock().

========================================== Starvation =================================
A thread is ready to run but keeps waiting for CPU time or resources because other threads continuously get preference.
The thread is alive, but it never gets a fair chance to execute.

Feature							Deadlock			Starvation
Threads waiting forever?		   Yes				Possibly
Circular dependency?			   Yes					No
Can work resume automatically?	    No					Maybe
Some threads progressing?		    No					Yes
System completely stuck?	    Usually Yes				No

Starvation occurs when a thread is perpetually denied access to CPU time or shared resources because other threads continuously receive preference. Unlike deadlock, some threads continue making progress while one or more threads keep waiting indefinitely. Common causes include thread priorities, unfair locking, and long synchronized sections. Starvation can be reduced by minimizing lock duration, avoiding excessive thread priorities, and using fair locking mechanisms such as ReentrantLock(true).


Long waiting of a thread where waiting never ends is called - deadlock.
Long waiting of a thread where waiting ends at certain point - starvation.

Ex: Low priority thread has to wait until completing all high priority threads. it may be long waiting but ends at certain point, which is nothing but starvation.
	