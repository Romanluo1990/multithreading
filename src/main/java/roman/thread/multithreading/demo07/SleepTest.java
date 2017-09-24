package roman.thread.multithreading.demo07;


public class SleepTest{
    public static void main(String[] args){
        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    for(int i=0; i <10; i++){
                        System.out.printf("%s: %d\n", Thread.currentThread().getName(), i);
                        // i能被4整除时，休眠100毫秒
                        if (i%4 == 0)
                            Thread.sleep(3000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(runnable,"t1");
        t1.start();
    }
}
