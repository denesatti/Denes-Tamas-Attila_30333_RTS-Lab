package ForLE1;

import java.util.concurrent.CountDownLatch;

public class Fir3 implements  Runnable{
    String name;
    Integer P13, P14;
    int min, max;

    boolean mp13recived = false;
    boolean mp14recived = false;

    CountDownLatch cdl;

    public Fir3(String name, Integer p13, Integer p14, int min, int max, CountDownLatch cdl) {
        this.name = name;
        P13 = p13;
        P14 = p14;
        this.min = min;
        this.max = max;
        this.cdl = cdl;
    }



    @Override
    public void run() {
        System.out.println(this.name + " is in state 1");

        System.out.println(this.name + " is in state 2");

        double k = Math.random()*(max-min)+min;
        for(int i = 0; i < k*1000000; i++){
            i++;i--;
        }


        System.out.println(this.name + " is in state 3");



        try {
            Thread.sleep(6*500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        synchronized (P13){
            P13.notify();
        }
        synchronized (P14){
            P14.notify();
        }


        System.out.println(this.name + " is in state 4");

        this.cdl.countDown();
    }

    public void start(){
        new Thread(this).start();
    }

}
