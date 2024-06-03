package LabSession5.App1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Fir extends Thread{
    Semaphore P9;
    Semaphore P10;
    CyclicBarrier T8;

    int name, delay, k, permit, min, max;

    public Fir (Semaphore P9, Semaphore P10, int n, int delay, int min, int max, int permit) {
        this.P9     = P9;
        this.P10    = P10;

        this.name   = n;
        this.delay  = delay;
        this.min    = min;
        this.max    = max;
        this.permit = permit;
    }

    public void run(){
        activity();
        try{
            T8.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    public void activity() {
        try {
            System.out.println("Fir " + this.name + "State 1");

            this.k = (int) (Math.random() * (max - min)) + min;
            for (int i = 0; i < 100000 * k; i++) {
                i++;
                i--;
            }
            if(P9.tryAcquire(1)){
                try{
                    System.out.println("Fir " + this.name + " took the token from semaphore " + P9.toString());
                    System.out.println("Fir " + this.name + "State 2");

                    this.k = (int) (Math.random() * (max - min)) + min + 2;
                    for (int i = 0; i < 100000 * k; i++) {
                        i++;
                        i--;
                    }
                }finally {
                    this.P9.release();
                }
            }



            System.out.println("Fir " + this.name + " released the token from semaphore " + P9.toString());

            if(P10.tryAcquire(1)){
                try{
                    System.out.println("Fir " + this.name + " took the token from semaphore " + P10.toString());
                    System.out.println("Fir " + this.name + "State 3");

                    Thread.sleep(this.delay * 500);
                }finally {
                    this.P10.release();
                }
            }

            System.out.println("Fir " + this.name + " released the token from semaphore " + P10.toString());
            System.out.println("Fir " + this.name + " State 4");



        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setCyclicBarrier(CyclicBarrier t8) {
        T8 = t8;
    }
}
