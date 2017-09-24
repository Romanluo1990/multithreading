package roman.thread.multithreading.demo05;

/**
 * (01) 主线程中新建并且启动了3个线程"t1", "t2"和"t3"。
 * (02) 主线程通过sleep(3000)休眠3秒。在主线程休眠3秒的过程中，我们假设"t1", "t2"和"t3"这3个线程都运行了。
 * 以"t1"为例，当它运行的时候，它会执行lock.wait()等待其它线程通过notify()或额nofityAll()来唤醒它；相同的道理，"t2"和"t3"也会等待其它线程通过nofity()或nofityAll()来唤醒它们。
 * (03) 主线程休眠3秒之后，接着运行。执行 lock.notifyAll() 唤醒lock上的等待线程，即唤醒"t1", "t2"和"t3"这3个线程。
 * 紧接着，主线程的synchronized(obj)运行完毕之后，主线程释放“lock锁”。这样，"t1", "t2"和"t3"就可以获取“lock锁”而继续运行了！
 */
public class NotifyAllTest {

    public static void main(String[] args) {

        final Object lock = new Object();

        Runnable runnable = new Runnable() {

            public void run() {
                synchronized (lock) {
                    try {
                        // 打印输出结果
                        System.out.println(Thread.currentThread().getName() + " wait");

                        // 唤醒当前的wait线程
                        //wait把线程放入lock锁对象的监视栈中
                        lock.wait();
                        Thread.sleep(3000);
                        // 打印输出结果
                        System.out.println(Thread.currentThread().getName() + " continue");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t1 = new Thread(runnable,"t1");
        Thread t2 = new Thread(runnable,"t2");
        Thread t3 = new Thread(runnable,"t3");
        t1.start();
        t2.start();
        t3.start();

        try {
            System.out.println(Thread.currentThread().getName()+" sleep(3000)");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized(lock) {
            // 主线程等待唤醒。
            System.out.println(Thread.currentThread().getName()+" notifyAll()");
           //notifyAll从lock锁对象的监视栈中顺序唤醒线程（一个一个唤醒，因为只有一个线程能有锁）
            //notify是随机唤醒
            lock.notifyAll();
//            lock.notify();
//            lock.notify();
//            lock.notify();

        }
    }


}


