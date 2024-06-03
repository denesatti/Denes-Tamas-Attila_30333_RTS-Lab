package ForLE;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Integer m = 2;
        Semaphore s = new Semaphore(3);


        CyclicBarrier cb = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("Threads joint by barrier.");
            }
        });

        Fir1 l_t = new Fir1(m,s,cb,3,5,3,"L_T");
        Fir2 r_t = new Fir2(m,s,cb,2,4,3,"R_T");

        l_t.start();
        r_t.start();


    }
}
