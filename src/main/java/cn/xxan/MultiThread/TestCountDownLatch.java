package cn.xxan.MultiThread;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 使用 。
 * await()方法，需要等doneSignal为0的时候才会执行。
 * 等待所有的线程都执行完成后，再执行下面的步骤
 */
public class TestCountDownLatch {

    private static final int N = 10;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch doneSignal = new CountDownLatch(N);//N为要控制的线程的数量
        CountDownLatch startSignal = new CountDownLatch(1);// 作为线程启动的开关，只有当startSignal执行一次countDown()方法，变为0的时候，startSignal.await()才会执行

        for (int i = 1; i <= N; i++) {
            new Thread(new Worker(i, doneSignal, startSignal)).start();// 线程启动了
        }
        System.out.println("begin------------");
        startSignal.countDown();// 开始执行啦

        doneSignal.await();// 等待所有的线程执行完毕，在所有线程未执行完成之前（doneSignal.getCount()>0），await()方法会受阻
        System.out.println("Ok");

    }

    static class Worker implements Runnable {
        private final CountDownLatch doneSignal;
        private final CountDownLatch startSignal;
        private int beginIndex;

        Worker(int beginIndex, CountDownLatch doneSignal,
               CountDownLatch startSignal) {
            this.startSignal = startSignal;
            this.beginIndex = beginIndex;
            this.doneSignal = doneSignal;
        }

        public void run() {
            try {
                startSignal.await(); // 等待startSignal.getCount()为0的时候，才会执行。
                beginIndex = (beginIndex - 1) * 10 + 1;
                for (int i = beginIndex; i <= beginIndex + 10; i++) {
                    System.out.println(i);
                }
                //
//                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("done Count"+doneSignal.getCount());
                doneSignal.countDown();//表示一个线程执行完成
                System.out.println("colsed done Count"+doneSignal.getCount());
            }
        }
    }
}
