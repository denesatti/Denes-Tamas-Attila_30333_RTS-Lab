package LabSession4.Lab7App4;

import java.util.concurrent.Semaphore;

public class Fir extends Thread{

    int min_d, max_d, delay;
    Semaphore s;
    Fir(Semaphore sa, int delay, int min, int max) {
        this.s = sa;
        this.delay = delay;
        this.min_d = min;
        this.max_d = max;
    }
    public void run() {
        while (true) {
            try {
                System.out.println(this.getName() + " - STATE 1");
                this.s.acquire(1); // critical region
                System.out.println(this.getName() + " took a token from the semaphore");

                System.out.println(this.getName() +" State 2");
                int k = (int) Math.round(Math.random() * (max_d - min_d) + min_d);
                for (int i = 0; i < k * 100000; i++) { i++; i--; }

                this.s.release(1); // end of critical region
                System.out.println(this.getName() + " released a token from the semaphore");
                System.out.println(this.getName()  +" State 3");

                try {
                    Thread.sleep(delay * 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(this.getName()  +" State 4");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
