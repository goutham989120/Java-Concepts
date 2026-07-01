====================================== Synchronization ============================================
1. Synchronized in the modifier only applicable for methods & blocks and not for classes and variables.
2. If multiple threads are trying to operate simultaneously on the same java object then there may be a chance of "data-inconsistency" problem. To overcome this problem we should go for synchronized keywork. If a method or block declared as synchronized then at a time only one thread is allowed to execute that method or block on the given object. So that data inconsistency problem will be resolved.
Disadvantage - it increases waiting time of threads and creates performance problems, hence if there is no specific requirment then it is not recommended to use synchronized keyword.

Synchronization is a mechanism that ensures only one thread at a time can access a critical section (shared resource).

It prevents problems like:

Race Conditions
Data Inconsistency
Lost Updates


Internally synchronized concept is implemented by using lock. Every object in Java has a unique lock. Whenever we are using synchronized keyword lock concept will come into picture.
If a thread wants to execute synchronized method on the given object 1st it has to get lock of that object. Once thread got the lock then it is allowed to execute any synchronized vmethod on that object. Once method execution completes automatically thread releases the lock.

Acquiring & releasing lock internally takes care by JVM and programmer not responsible for this activity.

While a thread executing synchronized method on a given object the remaining threads are not allowed to execute any synchronized method simultaneously on the same object. But remianing threads are allowed to execite non-synchronized method simultaneously.

class X {
	synch m1() 
	synch m2()
	m3()
}

Lock concept is implemented based on object but not based on method.

An object has - Synchronized and non-synchronized area

Synchronized area - This area can be accessed by only one thread at a time. Whereever we are performing update operation (add/remove/delete/replace) where state of object changing.

Non-synchronized area - This area can be accessed by any number of threads simultaneously. Where ever object state won't be changed like READ.


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
		MyThread t1 = new MyThread(d,"Mark");
		MyThread t2 = new MyThread(d,"David");
		t1.start();
		t2.start();
	}
}

If we are not declaring wish method as synchronized then both threads will executed simultaneously and hence we will get irregular output.