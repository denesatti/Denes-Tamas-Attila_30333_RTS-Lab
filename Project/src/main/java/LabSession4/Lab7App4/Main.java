package LabSession4.Lab7App4;


import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String args[]) {
        Semaphore s = new Semaphore(2);

        Fir f1 = new Fir(s,5,3,6);
        Fir f2 = new Fir(s,3,4,7);
        Fir f3 = new Fir(s,6,5,7);

        f1.start();
        f2.start();
        f3.start();

    }
}
