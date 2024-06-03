package ForLE1;

import java.util.concurrent.CountDownLatch;

public class Fir1 implements Runnable{
    int min, max ;
    String name;
    CountDownLatch cdl;



    public Fir1(int min, int max, String name, CountDownLatch cdl) {
        this.min = min;
        this.max = max;
        this.name = name;
        this.cdl = cdl;

    }

    public void run(){
        System.out.println(this.name + " is in state 1");
        System.out.println(this.name + " is in state 2");

        double k = Math.random()*(max-min)+min;
        for(int i = 0; i < k*1000000; i++){
            i++;i--;
        }

        System.out.println(this.name + " is in state 3");
        System.out.println(this.name + " is in state 4");

        this.cdl.countDown();


    }

    public void start(){
        new Thread(this).start();
    }

}
