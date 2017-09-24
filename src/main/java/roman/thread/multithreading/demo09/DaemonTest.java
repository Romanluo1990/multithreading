package roman.thread.multithreading.demo09;

public class DaemonTest {

    public static void main(String[] args) {

        Runnable runnable1 = new Runnable() {
            public void run() {
                try {
                    for (int i=0; i<3; i++) {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() +"(isDaemon="+Thread.currentThread().isDaemon()+ ")" +", loop "+i);
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            public void run() {
                try {
                    for (int i=0;; i++) {
                        Thread.sleep(500);
                        System.out.println(Thread.currentThread().getName() +"(isDaemon="+Thread.currentThread().isDaemon()+ ")" +", loop "+i);
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        System.out.println(Thread.currentThread().getName()
                +"(isDaemon="+Thread.currentThread().isDaemon()+ ")");

        Thread t1=new Thread(runnable1,"t1");    // 新建t1
        Thread t2=new Thread(runnable2,"t2");    // 新建t2
        t2.setDaemon(true);                // 设置t2为守护线程
        t1.start();                        // 启动t1
        t2.start();                        // 启动t2
    }
}
