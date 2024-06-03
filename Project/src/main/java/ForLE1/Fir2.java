package ForLE1;

import java.util.concurrent.CountDownLatch;

public class Fir2 implements Runnable{
    String name;
    Integer P13, P14;
    int min, max;

    boolean mp13recived = false;
    boolean mp14recived = false;

    CountDownLatch cdl;

    public Fir2(String name, Integer p13, Integer p14, int min, int max, CountDownLatch cdl) {
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
        synchronized (P13) {
            synchronized (P14) {
            try {
                P13.wait();
                P14.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Been notified by P13 and P14");
            }}


        double t = Math.random() * (max - min) + min * 500;
        try {
            Thread.sleep((long) t);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.name + " is in state 2");

        double k = Math.random()*(max-min)+min+1;
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
