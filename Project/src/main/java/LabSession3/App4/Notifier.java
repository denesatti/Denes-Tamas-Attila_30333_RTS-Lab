package LabSession3.App4;

public class Notifier implements Runnable{
    Integer monitor1;
    Integer monitor2;
    int sleep_min, sleep_max, activity_min, activity_max;

    public Notifier(Integer monitor1, Integer monitor2, int sleep_min, int sleep_max, int activity_min, int activity_max){

        this.monitor1 = monitor1;
        this.monitor2 = monitor2;

        this.sleep_min = sleep_min;
        this.sleep_max = sleep_max;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - STATE 1");
        try {
            Thread.sleep(Math.round(Math.random() * (sleep_max - sleep_min)+ sleep_min) * 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " - STATE 2.1");
        System.out.println(Thread.currentThread().getName() + " - STATE 2.2");
        int k1 = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i < k1 * 1000000; i++) {
            i++;
            i--;
        }
        System.out.println(Thread.currentThread().getName() + " - STATE 2.3");
        k1 = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i < k1 * 1000000; i++) {
            i++;
            i--;
        }
        System.out.println(Thread.currentThread().getName() + " - STATE 2.4");

        k1 = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i < k1 * 1000000; i++) {
            i++;
            i--;
        }
        synchronized (monitor1) {
            monitor1.notify();
        }
        synchronized (monitor2) {
            monitor2.notify();
        }
        System.out.println(Thread.currentThread().getName() + " - STATE 3");

    }

}
