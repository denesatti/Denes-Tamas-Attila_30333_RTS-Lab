package LabSession3.App4;

public class Waiter implements  Runnable{
    Integer monitor1;
    int sleep_min, sleep_max, activity_min, activity_max;

    Thread t;

    public Waiter(Integer monitor1, Thread notifier, int sleep_min, int sleep_max, int activity_min, int activity_max){

        this.monitor1 = monitor1;
        this.t = notifier;
        this.sleep_min = sleep_min;
        this.sleep_max = sleep_max;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - STATE 1");
        synchronized (monitor1) {
            try {
                monitor1.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " - STATE 2");
            int k2 = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for (int i = 0; i < k2 * 100000; i++) {
                i++;
                i--;
            }
        }

        System.out.println(Thread.currentThread().getName() + " - STATE 3");

        if (this.t != null) {
            try {
                this.t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }



}
