package roman.thread.multithreading.demo06;

/**
 * 主线程main中启动了两个线程t1和t2。t1和t2在run()会引用同一个对象的同步锁，即synchronized(obj)。
 * 在t1运行过程中，虽然它会调用Thread.yield()；但是，t2是不会获取cpu执行权的。因为，t1并没有释放“obj所持有的同步锁”！
 */
public class YieldLockTest {

    public static void main(String[] args){
        Runnable runnable = new Runnable() {
            public synchronized void run() {
                for(int i=0; i <10; i++){
                    System.out.printf("%s [%d]:%d\n", Thread.currentThread().getName(), Thread.currentThread().getPriority(), i);
                    // i整除4时，调用yield
                    if (i%4 == 0)
                        Thread.yield();
                }
            }
        };

        Thread t1 = new Thread(runnable,"t1");
        Thread t2 = new Thread(runnable,"t2");
        t1.start();
        t2.start();
    }
}
