========================== Thread Interruption ==============================
Waiting of Child thread until completing Main thread

class myThread extends Thread {
	static Thread mt;
	public void run() {
		try {
			mt.join();
		}catch(InterruptedException e) {
			for(int i = 0; i < 10; i++) {
				{
					System.out.println("Child Thread");
				}
			}
		}
	}
}

class ThreadJoinDemo {
	public static void main(String[] args) {
		myThread.mt = Thread.currentThread();
		myThread t = new myThread();
		t.start();
		for(int i = 0; i < 10; i++) {
			System.out.println("Main Thread");
			Thread.sleep(2000);
		}
	}
}
		
If main thread calls join() on child thread object and child thread calls join() on main thread object then both threads will wait forever and the program will be stucked , this is something like deadlock.

Case 4:
class Test {
	public static void main(String[] args) {
		Thread.currentThread.join();
	}
}

If a thread calls join() on the same thread itself then the program will be stucked , this is something like deadlock, in this case thread has to wait infinite amount of time

================================================== sleep() =========================================
If a thread don't want to perform any operation for particular amount of time - sleep()

public static native void sleep(long ms) throws InterruptedException
public static void sleep(long ms, int ns) throws InterruptedException

Thread.sleep() is used to pause the currently executing thread for a specified amount of time.
Thread.sleep() is a static method that pauses the currently executing thread for a specified duration. During sleep, the thread enters the TIMED_WAITING state and does not release any locks it holds. It is useful for intentional delays such as retries or simulations but should generally not be used for thread coordination or waiting for data because better concurrency utilities exist for those scenarios.

class MyThread extends Thread {
    public void run() {
        try {
            System.out.println("Child Started");

            Thread.sleep(2000);

            System.out.println("Child Completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Demo {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();

        System.out.println("Main Completed");
    }
}

================================================= How a thread can interrupt another thread ? ===============================
A thread can interrupt a sleeping or waiting thread by using interrupt() of thread class - public void interrupt().
A thread can interrupt another thread by calling:


class myThread extends Thread {
	public void run() {
		try {
			for(int i = 0; i < 10; i++) {
				System.out.println("I am lazy thread");
				Thread.sleep();
			}
		}
		catch(InterruptedException e) {
			System.out.println("I got intterupted");
		}
	}
}

class ThreadinterruptDemo {
	public static void main(Strong[] args) {
		myThread t = new myThread();
		t.start();
		t.intterupt();
		System.out.println("End of Main");
	}
}

Output:
End of Main
I am lazy thread
I got intterupted

Whenever we are calling interrupt() if the target thread is not in sleeping state then there is no impact call immediately, interrupt call will wait until target entered into sleeping or waiting state. If the target thread entered into sleeping or waiting state then immediately interrupt call will intterupt target thread.

If the target thread never entered into sleeping or waiting state in it's life time then there is no impact of interrupt call , this is the only case where interrupt call is wasted.

class MyThread extends Thread {
	public void run() {
		for(int i = 0; i < 10000; i++) {
			System.out.println("I am lazy Thread-" +i);
		}
		System.out.println("I am entering into sleeping state");
		try {
			Thread.sleep(10000);
		}
		catch(InterruptedException e) {
			System.out.println("I got intterupted");
		}
	}
}

class ThreadSleepDemo1 {
	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
		t.interrupt();
		System.out.println("End of main thread");
	}
}


============================

class MyThread extends Thread {
    public void run() {
        try {
            System.out.println("Child started");

            Thread.sleep(5000);

            System.out.println("Child completed");
        } catch (InterruptedException e) {
            System.out.println("Child interrupted!");
        }
    }
}

public class Demo {
    public static void main(String[] args)
            throws InterruptedException {

        MyThread t = new MyThread();
        t.start();

        Thread.sleep(2000);

        System.out.println("Main interrupting child...");
        t.interrupt();
    }
}