package LabSession4.Lab4App2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String args[]) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Fir f1 = new Fir(lock1,lock2,4, 2,4);
        Fir f2 = new Fir(lock2,lock1,5, 3,5);

        f1.start();
        f2.start();
    }
}
