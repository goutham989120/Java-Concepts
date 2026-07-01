==================================== Daemon Threads ===========================
The threads which are executing in the background are called - Daemon threads. ex: Garbage collector, signal dispatcher, attach listner etc.
In Java, a Daemon Thread is a background thread that provides services to user threads. The JVM does not wait for daemon threads to finish. When all user (non-daemon) threads complete, the JVM terminates automatically, even if daemon threads are still running.

Use the setDaemon(true) method before starting the thread.

Thread t = new Thread();
t.setDaemon(true);
t.start();

If you call setDaemon(true) after start(), Java throws:

java.lang.IllegalThreadStateException

The main objective of Daemon threads is to provide support for non-daemon threads(main thread - if it runs with low memory, then JVM runs garbage collector to destroy useless objects, so that number of bytes of free memory improved.WIth this free memory main thread can continue it's execution).

Usually daemon threads having low priority, but based on our requirement daemon threads can run on high priority also.

1. public boolean isDaemon()
2. public void setDaemon(boolean b)

By default main thread is non-daemon and for all remianing threads daemon nature will be inherited from parent to child i.e., if parent thread is daemon then automatically child thread is also daemon and if the parent therad is non-daemon then automatically child thread is also non-daemon.

Note: It is impossible to change daemon nature of main thread because it is already started by JVM at the beginning.

class MyThread extends Thread {
}

class Test {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().isDaemon()); // false
		Thread.currentThread().setDaemon(true); // RE: IllegalThreadStateException
		MyThread t = new MyThread();
		System.out.println(t.isDaemon()); // false
		t.setDaemon(true);
		System.out.println(t.isDaemon()); // true
	}
}

When ever last non-daemon threads terminates automatically all daemon threads will be terminated irrespective of their position.

class MyThread extends Thread {
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("Child Thread");
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
			}
		}
	}
}

class DaemonThreadDemo {
	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.setDaemon(true);
		t.start();
		System.out.println("End of main thread");
	}
}