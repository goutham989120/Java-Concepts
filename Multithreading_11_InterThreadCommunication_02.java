======================================== Inter Thread Communication - Part01 ==========================
Inter-thread communication is timing-sensitive.
The waiting thread must already be waiting when notify() occurs.

class ThreadA {
	public static void main(String[] args) {
		ThreadB b = new ThreadB();
		b.start();
		// Thread.sleep(10000);
		synchronized(b) {
			System.out.println("Main thread calling wait method"); // 1.
			b.wait();
			System.out.println("Main thread got notification"); // 4.
			System.out.println(b.total); // 5.
		}
	}
}
class ThreadB extends Thread {
	int total = 0;
	public void run() {
		synchronized(this) {
			System.out.println("Child thread starts calculation"); // 2.
			for(int i = 0; i <= 100; i++) {
				total = total + 1;
			}
			System.out.println("Child thread giving notification"); // 3.
			this.notify();
		}
	}
}

Output:
Main thread calling wait method
Child thread starts calculation
Child thread giving notification
Main thread got notification
5050

======================================= Producer Consumer Problem ========================

Producer thread is responsible to produce items to the queue and consumer thread is responsible to consume items from the queue. If queue is empty then consumer() will call wait() and enter into waiting state. After producing items to the queue producer thread is responsible to call notify() and then waiting consumer will get the notification & continue it's execution with updated items.

class ProducerThread {
	produce() {
		synchronized(q) {
			// produce items to the queue
			q.notify();
		}
	}
}

class ConsumerThread {
	consume() {
		synchronized(q) {
			if(q is empty) {
				q.wait();
			} else {
				// consume item
			}
		}
	}
}

We can use notify() to give the notification for only one waiting thread , if multiple threads are waiting then only one thread will notify and the remianing threads have to wait for further notifications. WHich thread will be notify we can't expect , it depends on JVM.

We can use notifyAll() to give the notification for all waiting threads of a particular object. Even though multiple threads notify but execution will be performed one by one because threads required lock and only one lock is available.

class SharedResource {
    private int data;
    private boolean available = false;

    public synchronized void produce(int value)
            throws InterruptedException {

        while (available) {
            wait();
        }

        data = value;
        available = true;

        System.out.println(
                "Produced : " + value);

        notify();
    }

    public synchronized void consume()
            throws InterruptedException {

        while (!available) {
            wait();
        }

        System.out.println(
                "Consumed : " + data);

        available = false;

        notify();
    }
}

class Producer extends Thread {

    private SharedResource resource;

    Producer(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {

        try {
            for (int i = 1; i <= 5; i++) {

                resource.produce(i);

                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Consumer extends Thread {

    private SharedResource resource;

    Consumer(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {

        try {
            for (int i = 1; i <= 5; i++) {

                resource.consume();

                Thread.sleep(1500);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ProducerConsumerDemo {

    public static void main(String[] args) {

        SharedResource resource =
                new SharedResource();

        Producer producer =
                new Producer(resource);

        Consumer consumer =
                new Consumer(resource);

        producer.start();
        consumer.start();
    }
}

