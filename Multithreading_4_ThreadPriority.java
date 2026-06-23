=============================== Thread Priorities ============================
In Java, Thread Priority is a hint to the thread scheduler about which thread should get CPU time first.However, priority does not guarantee execution order. The operating system's scheduler ultimately decides which thread runs.

Thread.MIN_PRIORITY - 1
Thread.NORM_PRIORITY - 5
Thread.MAX_PRIORITY - 10

Thread scheduler will use the priorities while allocating processor. The thread with high priority get the chance 1st.
Thread class defines the following method to get and set priority of a thread -

public final void setPriority(int newPriority)
public final int getPriority()

If you pass a value outside this range, Java throws an IllegalArgumentException.

Thread t = new Thread();

t.setPriority(8);
System.out.println(t.getPriority());

=========================== Default Priority ======================================
The default priority for Main thread - 5, but for all remaining threads default priority will be inherited from parent to child.
whatever priority parent thread has the same priority will be there for child thread.
 
class myThread extends Thread {
}
class Test {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getPriority()); - 5
		Thread.currentThread().setPriority(7);
		myThread t = new myThread();
		System.out.println(t.getPriority());
	}
}

===================

class myThread extends Thread {
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("Child Thread");
		}
	}
}

class ThreadPriorityDemo {
	public static void main(String[] args) {
		myThread t = new myThread();
		t.setPriority(10);
		t.start();
		for(int i = 0; i < 10; i++) {
			System.out.println("Main Thread");
		}
	}
}



===============


class MyThread extends Thread {
    public void run() {
        System.out.println(getName() + " Priority: " + getPriority());
    }
}

public class ThreadPriorityDemo {
    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.setName("Thread-1");
        t2.setName("Thread-2");

        t1.setPriority(3);
        t2.setPriority(8);

        t1.start();
        t2.start();
    }
}

======