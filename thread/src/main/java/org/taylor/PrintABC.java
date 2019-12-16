package org.taylor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author taylor
 * @date 2019/12/16 16:48
 */
public class PrintABC {
    public static void main(String[] args) {

        Print print = new Print();

        new Thread(print::printA).start();

        new Thread(print::printB).start();

        new Thread(print::printC).start();

    }

}


class Print {

    private final Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();
    private int flag = 1;


    void printA() {
        lock.lock();
        try {
            while (true) {
                while (flag != 1) {
                    conditionA.await();
                }
                System.out.println("A");
                flag = 2;
                conditionB.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    void printB() {
        lock.lock();
        try {
            while (true) {
                while (flag != 2) {
                    conditionB.await();
                }
                System.out.println("B");
                flag = 3;
                conditionC.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void printC() {
        lock.lock();
        try {
            while (true) {
                while (flag != 3) {
                    conditionC.await();
                }
                System.out.println("C");
                flag = 1;
                conditionA.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
