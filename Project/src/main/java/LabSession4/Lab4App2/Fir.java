package LabSession4.Lab4App2;

import java.util.concurrent.locks.Lock;

public class Fir extends Thread{
    Lock l1;
    Lock l2;
    int sleep, activity_min, activity_max;

    public Fir(Lock l1,Lock l2, int sleep, int activity_min, int activity_max){
        this.sleep = sleep;
        this.activity_min = activity_min;
        this.activity_max = activity_max;

        this.l1 = l1;
        this.l2 = l2;
    }


    public void run(){
        System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        this.l1.lock();
        System.out.println(this.getName() + " - STATE 2");
        k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min + 2);// +2 from the petrinet
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        if(this.l2.tryLock()){
            try {
                l2.lock();

                System.out.println(this.getName() + " - STATE 3");

                try {
                    Thread.sleep(sleep * 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }finally {
                l1.unlock();

            }

        }
        l1.unlock();

        System.out.println(this.getName() + " - STATE 4");


    }
}
