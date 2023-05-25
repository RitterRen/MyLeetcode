package MultipleThreads;

// Inherit from Thread, rewrite run() function
public class TestThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("我在看代码--" + i);
        }
    }

    public static void main(String[] args) {
        TestThread1 thread1 = new TestThread1();

        thread1.start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("我在学习多线程--" + i);
        }
    }
}
