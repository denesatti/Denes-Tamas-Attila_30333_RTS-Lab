package LabSession5.App1;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String args[]){
        Semaphore semP9 = new Semaphore(1);
        Semaphore semP10 = new Semaphore(1);

        Fir fir1 = new Fir(semP9, semP10, 1, 4,  2,4,1);
        Fir fir2 = new Fir(semP10, semP9,2, 5,  3,5,1);


        CyclicBarrier cycbarT8 = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("Cyclic barrier routine.");

                //What should i add here or how should the program work?


            }
        });

        fir1.setCyclicBarrier(cycbarT8);
        fir2.setCyclicBarrier(cycbarT8);

        fir1.start();
        fir2.start();
    }
}
