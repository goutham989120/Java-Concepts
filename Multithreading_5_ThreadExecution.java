=========================== Prevent Thread Execution ==================
We can prevent a thread execution by using the following methods -
1. yield()
2. join()
3. sleep()

========================================= yield() ===================================================
yield() causes to pause current executing thread to give the chance for waiting threads of same priority.
If there is no waiting thread or all waiting threads have low priority then same thread can continue it's execution.

If multiple threads are waiting with same priority then we can't expect which waiting thread with get the chance , it depends on thread scheduler.

When a thread calls yield(), it says to the scheduler:
"I am willing to pause for a moment. If there is another thread of the same or higher priority waiting, you may give the CPU to that thread."
Important: yield() is only a hint to the scheduler. The scheduler may ignore it, and the same thread may continue executing.

"public static native void yield(); "

class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Child Thread");
            Thread.yield();
        }
    }
}

public class YieldDemo {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread");
        }
    }
}

Possible output1:
Child Thread
Main Thread
Main Thread
Main Thread
Main Thread
Main Thread
Child Thread
Child Thread
Child Thread
Child Thread   

The thread which is yielded, it will get the chance based on the thread scheduler, & we can't expect exactly.

class myThread extends Thread {
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("Child thread");
		}
	}
}

class ThreadYieldDemo {
	public static void main(String[] args) {
		myThread t = new myThread();
		t.start();
		for(int i = 0; i < 10; i++) {
			System.out.println("Main thread");
		}
	}
}

Output : Main thread will complete 1st

================================================= Yield() ========================================
================================================= join() =========================================
If a thread wants to wait until completing some other thread then we should go for join();
Ex: Thread t1 wants to wait until completing t2 then t1 has to call t2.join();
If t1 executes t2.join() then immediatly t1 will be entered into waiting status until t2 completes. Once t2 completes then t1 can continue it's execution.

The join() method is used when one thread has to wait until another thread completes its execution.

t.join() means: "Current thread, wait until thread t finishes."

Method Signature -
public final void join() throws InterruptedException
public final void join(long millis) throws InterruptedException
public final void join(long millis, int nanos) throws InterruptedException

Main Thread -----> Running
                     |
                     | t.join()
                     v
                  Waiting
                     |
                     | Child completes
                     v
                  Runnable
                     |
                     v
                  Running
				  
				  
class myThread extends Thread {
	public void run() {
		for(int i = 0; i < 10; i++) {
		    System.out.println("Child thread");
			try {
				Thread.sleep(2000);
			}
			catch(InterruptedException e) {
			}
		}
	}
}

class ThreadJoinDemo {
	public static void main(String[] args) {
		myThread t = new myThread();
		t.start();
		t.join(10000);
		for(int i = 0; i < 10; i++) {
			System.out.println("Main thread");
		}
	}
}
		