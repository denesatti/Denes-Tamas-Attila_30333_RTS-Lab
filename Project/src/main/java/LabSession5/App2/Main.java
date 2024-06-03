package LabSession5.App2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String args[]) throws InterruptedException {
        Lock P9 = new ReentrantLock();
        Lock P10 = new ReentrantLock();

        CountDownLatch cdl = new CountDownLatch(3);

        Fir fir_l = new Fir(P9,cdl,"Left", 4, 2,4);
        Fir fir_r = new Fir(P10,cdl,"Right", 5, 2,5);
        Fir_middle fir_m = new Fir_middle(P9,P10,cdl, "Middle",3,3,6);

        fir_l.start();
        fir_r.start();
        fir_m.start();

        cdl.await();

    }
}
