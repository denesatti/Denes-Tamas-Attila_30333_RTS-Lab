package LabSession5.App2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

public class Fir implements Runnable{
    Lock P9;
    CountDownLatch cdl;
    String name;
    int tt, p_t_min, p_t_max;



    public Fir(Lock p9,CountDownLatch cdl ,String name, int tt, int p_t_mnin, int p_t_max) {
        P9 = p9;
        this.name = name;
        this.tt = tt;
        this.p_t_min = p_t_mnin;
        this.p_t_max = p_t_max;
        this.cdl = cdl;
    }
    public void run(){
        System.out.println(this.name + " is in state 1.");
            P9.lock();
            System.out.println(this.name + " is in state 2.");

            double k = Math.random() * (p_t_max - p_t_min) + p_t_min;
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }

        try {
            Thread.sleep(tt * 500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        P9.unlock();


        System.out.println(this.name + " is in state 3.");

        cdl.countDown();

    }




    public void start(){
        new Thread(this).start();
    }



}
