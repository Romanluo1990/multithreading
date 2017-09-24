package roman.thread.multithreading.demo08;

/**
 * join() 的作用：让“主线程”等待“子线程”结束之后才能继续运行。
 */
public class JoinTest {

    public static void main(String[] args){
        try {
            Runnable runnable = new Runnable() {
                public void run() {
                    System.out.printf("%s start\n", Thread.currentThread().getName());

                    // 延时操作
                    for(int i=0; i <1000000; i++)
                        ;

                    System.out.printf("%s finish\n", Thread.currentThread().getName());
                }
            };
            Thread t1 = new Thread(runnable,"t1"); // 新建“线程t1”

            t1.start();                     // 启动“线程t1”
            t1.join();                        // 将“线程t1”加入到“主线程main”中，并且“主线程main()会等待它的完成”
            System.out.printf("%s finish\n", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
