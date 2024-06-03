package ForLE1;

import java.util.concurrent.CountDownLatch;

public class Main
{
    public static void main(String[] args) throws InterruptedException {
        Integer P13 = new Integer(1);
        Integer P14 = new Integer(2);

        CountDownLatch cdl = new CountDownLatch(3);

        Fir1 rf = new Fir1(7,9,"RF",cdl);
        Fir2 mf = new Fir2("MF",P13,P14,4,6,cdl);
        Fir3 lf = new Fir3("Lf",P13,P14,3,5,cdl);

        rf.start();
        mf.start();
        lf.start();

        cdl.await();

        System.out.println("All threads are united.");

    }
}
