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

	