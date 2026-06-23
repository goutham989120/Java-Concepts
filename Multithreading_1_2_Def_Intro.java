================================ Multitasking =======================
Executing several tasks simultaneously is the concept of multitasking.
Two types - Process based and Thread based
1. Process Based Multitasking - executing several tasks simultaneously where each task is a seperate independent program(process_)
Ex: Typing, listen songs, download files all at the same time. Best suitable at OS level.
2. Thread Based Multitasking - executing several tasks simultaneously where each task is seperate independent part of same program.
And each independent part is called thread. Best suitable at programatic level.
Multithreading is a programming technique where multiple threads execute concurrently within the same process.
Think of a process as an application (like Chrome or your Java application), and threads as workers inside that application

Objective - To reduse the response time of the system and to improve performance.

================================ Multitasking =======================

=============================================== Thread ===================================
Define Thread - we can define a thread in the following 2 ways -
1. By extending thread class
2. By implementing Runnable interface

class myThread extends Thread {
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("Child Thread");
		}
	}
}

class ThreadDemo {
	public static void main(String[] args) {
		myThread t = new myThred(); // thread instantiation
		t.start(); // Starting of a thread
		for(int i = 0; i < 10; i++) {
			System.out.println("Main Thread");
		}
	}
}

=============================================== Thread ===================================
=============================================== Thread Scheduler ===================================
Case 1:
Part of JVM which is responsible to schedule threads - i.e., if multiple threads are waiting to get the chance of execution then in which order the threads will be executed is decided by thread scheduler.
We can't expect exact algo followed by thread scheduler it is varied from JVM to JVM , hence we can't expect threads execution order & exact output.
Hence whenever situation comes to multithreading there is no gaurantee for exact output. But we can provide several possible outputs.

Case 2:
t.start() - a new thread is created which is responsible for the execution of run method.
t.run() - a new thread won't be created and run method will be executed just like a normal method call by main thread.
Hence in the above program t.start() with t.run() then the output is same forever on any machine produced by main thread.

class MyThread extends Thread {
    public void run() {
        System.out.println(
            "Running in : "
            + Thread.currentThread().getName()
        );
    }
}

public class Demo {
    public static void main(String[] args) {

        MyThread t = new MyThread();

        t.run();

        System.out.println("Main completed");
    }
}
Output:
Running in : main
Main completed

Case 3:
Importance of thread class start method - is responsible to register the thread with thread scheduler and other mandatory activities hence without executing t.start() there is no chance of starting a new thread in Java due to this t.start() is considered as heart of multithreading.

The start() method is one of the most important methods in multithreading because it creates a new thread and asks the JVM to execute the run() method on that new thread.

Thread t = new MyThread();
t.start();

Internally
1. JVM creates a new thread.
2. Allocates a new stack memory for that thread.
3. Registers the thread with the Thread Scheduler.
4. Scheduler decides when the thread gets CPU time.
5. The new thread eventually executes run().

Case 4:
Overloading of run method - is always possible but thread class start() can invoke "no-arg" run(). The other overloaded method we have to call explicitly like a normal method call.

Yes, the run() method can be overloaded in Java, but only the no-argument run() method is executed when you call start().

class MyThread extends Thread {

    public void run() {
        System.out.println("run() method");
    }

    public void run(int x) {
        System.out.println("run(int) method");
    }
}

class MyThread extends Thread {

    public void run() {
        System.out.println(
            "run() executed by "
            + Thread.currentThread().getName()
        );
    }

    public void run(int x) {
        System.out.println("run(int) method");
    }
}

public class Demo {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}

Output : run() executed by Thread-0

Case 5:
If we are not overriding run() - then t.run() will be executed which has empty implementation, hence no output
class MyThread extends Thread {
    // No run() method
}

public class Demo {
    public static void main(String[] args) {
        MyThread t = new MyThread();

        System.out.println("Before start()");
        t.start();
        System.out.println("After start()");
    }
}

Case 6:
Override of start() - if we override start() then our start method will be executed just like a normal method call and new thread won't be created.
Yes, start() can be overridden because it is not final. However, it should rarely be overridden. The original Thread.start() method is responsible for creating a new thread and invoking run() on that thread. If we override start() and do not call super.start(), no new thread is created and multithreading is lost. If additional logic is needed, we can override start() and delegate to super.start(), but in practice, overriding run() is preferred over overriding start().

class MyThread extends Thread {

    public void start() {
        System.out.println("Before creating thread");
        super.start();
        System.out.println("After creating thread");
    }

    public void run() {
        System.out.println("run() executed by " + Thread.currentThread().getName());
    }
}

public class Demo {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}

Before creating thread
After creating thread
run() executed by Thread-0

Before creating thread
After creating thread
run() executed by Thread-0

=================================== Life Cycle of a Thread ============================================
A thread in Java goes through five major states during its lifetime.

NEW
  |
start()
  |
RUNNABLE
  |
Scheduler gives CPU
  |
RUNNING
  |
sleep()/wait()/I/O/lock
  |
BLOCKED/WAITING/TIMED_WAITING
  |
Task completed
  |
TERMINATED

=================================== Life Cycle of a Thread ============================================
After starting a thread if we are trying to restart the same thread then we will get runtime exception - IllegalThreadStateException.

class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }
}

public class Demo {
    public static void main(String[] args) {

        MyThread t = new MyThread();

        t.start();
        t.start();   // Exception here
    }
}




 
