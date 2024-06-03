package ForLE;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Fir1 implements Runnable
{
    Integer m;
    Semaphore s;

    CyclicBarrier cb;

    int min, max, Td;
    String Name;


    public Fir1(CyclicBarrier cb) {
        this.cb = cb;
    }

    public Fir1(Integer m, Semaphore s, CyclicBarrier cb, int min, int max, int td, String Name) {
        this.m = m;
        this.s = s;
        this.min = min;
        this.max = max;
        this.Td = td;
        this.Name = Name;
        this.cb = cb;
    }


    @Override
    public void run() {
        System.out.println(Name + " is in state 1");
        try {
            s.acquire(3);
            synchronized (this.m){
                m.notify();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



        System.out.println(Name + " is in state 2");

        double k = Math.random()*(max-min)+min;
        for(int i = 0; i < k*100000; i++){
            i++;i--;
        }

        try {
            Thread.sleep(Td*500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Name + " is in state 3");

        s.release(3);
        k = Math.random()*(max-min)+min + 1;
        for(int i = 0; i < k*100000; i++){
            i++;i--;
        }

        System.out.println(Name + " is in state 4");

        try {
            cb.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

        this.run();
    }

    public void start(){
        new Thread(this).start();
    }
}
