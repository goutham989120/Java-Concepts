=============================== Multi-Threading ==============================
Green Thread model - thread which is managed completely by JVM without taking underlying OS support. 
Native OS model - thread which is managed by the JVM with the help of underlying OS.(All windows based OS)

How to stop a thread ? - t.stop() of thread class - public void stop();
How to suspend/resume of a thread ?
public void suspend() - t.suspend();
public void resume() - t.resume();