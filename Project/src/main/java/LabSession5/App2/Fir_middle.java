package LabSession5.App2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

public class Fir_middle implements Runnable{
    Lock P9,P10;
    int locked;
    CountDownLatch cdl;
    String name;
    int tt, p_t_min, p_t_max;

    public Fir_middle(Lock p9, Lock p10,CountDownLatch cdl ,String name, int tt, int p_t_mnin, int p_t_max) {
        P9 = p9;
        P10 = p10;
        this.name = name;
        this.tt = tt;
        this.p_t_min = p_t_mnin;
        this.p_t_max = p_t_max;
        this.cdl = cdl;
    }


    public void run(){
        System.out.println(this.name + " is in state 1.");

        while (true) {
            if (P9.tryLock()) {
                P9.lock();
                locked = 1;
            } else {
                P10.lock();
                locked = 2;
            }
            try {

                System.out.println(this.name + " is in state 2.");

                double k = Math.random() * (p_t_max - p_t_min) + p_t_min;
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }

                Thread.sleep(tt * 500);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                if (locked == 1) {
                    P9.unlock();
                } else if (locked == 2) {
                    P10.unlock();
                }
                break;
            }
        }
        System.out.println(this.name + " is in state 3.");

        cdl.countDown();

    }




    public void start(){
        new Thread(this).start();
    }



}
