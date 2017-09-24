package roman.thread.multithreading.demo06;

/**
 * yield()的作用是让步。它能让当前线程由“运行状态”进入到“就绪状态”，从而让其它具有相同优先级的等待线程获取执行权；
 * 但是，并不能保证在当前线程调用yield()之后，其它具有相同优先级的线程就一定能获得执行权；
 * 也有可能是当前线程又进入到“运行状态”继续运行！
 */
public class YieldTest{
    public static void main(String[] args){
        ThreadA t1 = new ThreadA("t1");
        ThreadA t2 = new ThreadA("t2");
        ThreadA t3 = new ThreadA("t3");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }

    static class ThreadA extends Thread{
        public ThreadA(String name){
            super(name);
        }
        public void run(){
            for(int i=0; i <10; i++){
                System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
                // i整除4时，调用yield
                if (i%4 == 0)
                    Thread.yield();
            }
        }
    }
}