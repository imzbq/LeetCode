package test.other;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
要求创建3个线程，这3个线程循环执行+5操作，当加到目标值时停止。
 */
public class ThreeThreads {

    private static int count = 0;
    private static int num = 0;
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();

        int target = 75;

        Thread t1 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                lock.lock();
                try {
                    while (count % 3 != 0) {
                        c1.await();
                    }
                    for (int i = 0; i < 5; i++) {
                        if (num == target) {
                            Thread.currentThread().interrupt();
                            System.out.println("线程A" + (Thread.currentThread().isInterrupted() ? "线程已关闭" : "线程未关闭"));
                            break;
                        } else {
                            num++;
                        }
                        System.out.println("线程A==" + num);
                    }
                    count++;
                    c2.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                lock.lock();
                try {
                    while (count % 3 != 1) {
                        c2.await();
                    }
                    for (int i = 0; i < 5; i++) {
                        if (num == target) {
                            Thread.currentThread().interrupt();
                            System.out.println("线程B" + (Thread.currentThread().isInterrupted() ? "线程已关闭" : "线程未关闭"));
                            break;
                        } else {
                            num++;
                        }
                        System.out.println("线程B==" + num);
                    }
                    count++;
                    c3.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        t2.start();

        Thread t3 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                lock.lock();
                try {
                    while (count % 3 != 2) {
                        c3.await();
                    }
                    for (int i = 0; i < 5; i++) {
                        if (num == target) {
                            Thread.currentThread().interrupt();
                            System.out.println("线程C" + (Thread.currentThread().isInterrupted() ? "线程已关闭" : "线程未关闭"));
                            break;
                        } else {
                            num++;
                        }
                        System.out.println("线程C==" + num);
                    }
                    count++;
                    c1.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        t3.start();
    }
}
