package roman.thread.multithreading.demo07;

/**
 * wait()的作用是让当前线程由“运行状态”进入“等待(阻塞)状态”的同时，也会释放同步锁。
 * 而sleep()的作用是也是让当前线程由“运行状态”进入到“休眠(阻塞)状态”。
 * 但是，wait()会释放对象的同步锁，而sleep()则不会释放锁。
 */
public class SleepLockTest {

    public static void main(String[] args){
        Runnable runnable = new Runnable() {
            public synchronized void run() {
                for(int i=0; i <10; i++){
                    System.out.printf("%s: %d\n", Thread.currentThread().getName(), i);
                }
            }
        };
        Thread t1 = new Thread(runnable,"t1");
        Thread t2 = new Thread(runnable,"t2");
        t1.start();
        t2.start();
    }

}
