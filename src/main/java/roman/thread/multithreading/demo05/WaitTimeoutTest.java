package roman.thread.multithreading.demo05;

/**
 * (01) 主线执行synchronized(o)程拿到锁
 * (02) 主线程main执行lock.wait(3000)，此时，主线程进入“阻塞状态”。
 * lock对象锁的线程通过notify() 或者 notifyAll()将其唤醒” 或者 “超时3000ms之后”，主线程main才进入到“就绪状态”，然后才可以运行。
 * (03) 超时3000ms之后，主线程main会进入到“就绪状态”，然后接着进入“运行状态”。
 */
public class WaitTimeoutTest {

    public static void main(String[] args) {

        Object lock = new Object();
        synchronized(lock) {
            try {

                // 主线程等待t1通过notify()唤醒 或 notifyAll()唤醒，或超过3000ms延时；然后才被唤醒。
                System.out.println(Thread.currentThread().getName() + " call wait ");
                lock.wait(3000);

                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
