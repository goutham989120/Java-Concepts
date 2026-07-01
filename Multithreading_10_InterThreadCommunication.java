========================================= Inter Thread Communication ================================
Two threads can communicate with each other by -
1. wait()
2. notify()
3. notifyAll()

These methods belong to - java.lang.Object because - "because every object has a monitor (lock)."

The thread which is expecting updation is responsible to call wait() then immediately the thread will enter into waiting state.
The thread which is responsible to perform updation, after performing updation it is responsible to call notify(), then waiting thread will get the notification and continue it's execution with those updated items.

Inter-Thread Communication is a mechanism where one thread waits for a condition, and another thread notifies it when the condition becomes true.

All these methods are present in object class because thread can call these methods on any Java object.

To call wait(), notify() notifyALL() on any object, thread should be owner of that object, that is thread should has lock of that object that is the thread should be synchronized area. Hence we can call all these methods only from synchronized area.Otherwise RE: IllegalMonitorStateException.

 All these methods are called "only in synchronized area". Otherwise RE: IllegalMonitorStateException.
 
 If a thread calls wait method on any object it immediately releases the lock of that object and enter into waiting state.
 If a thread calls notify() on any object it releases the lock of the object may not immediately. Except wait(), notify(), notifyAll() there is no other method where thread releases the lock.
 
 public final void wait() throws InterruptedException
 public final native void wait(long ms) throws InterruptedException
 public final void wait(long ms, int ns) throws InterruptedException
 
 public final native void notify()
 public final native void notifyAll()




