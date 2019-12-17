package org.taylor;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 同步方式三个线程顺序打印ABC
 * @author taylor
 * @date 2019/12/16 17:09
 */
public class SyncPrintABC {

    public static void main(String[] args) {

        Print1 Print1 = new Print1();

        new Thread(Print1::printA, "A").start();

        new Thread(Print1::printB, "B").start();

        new Thread(Print1::printC, "C").start();

    }
}

class Print1 {
    private int flag = 1;
    private AtomicInteger number = new AtomicInteger(0);

    synchronized void printA() {
        try {
            while (true) {
                while (flag != 1) {
                    wait();
                }
                System.out.println(number.incrementAndGet() + "  A");
                TimeUnit.SECONDS.sleep(1);
                flag = 2;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void printB() {
        try {
            while (true) {
                while (flag != 2) {
                    wait();
                }
                System.out.println(number.incrementAndGet() + "  B");
                TimeUnit.SECONDS.sleep(1);
                flag = 3;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void printC() {
        try {
            while (true) {
                while (flag != 3) {
                    wait();
                }
                System.out.println(number.incrementAndGet() + "  C");
                TimeUnit.SECONDS.sleep(1);
                flag = 1;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
