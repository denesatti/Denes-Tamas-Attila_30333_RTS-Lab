package LabSession3.App2;

public class ExecutionThread extends Thread{
    Integer monitor1;
    Integer monitor2;



    int sleep_min, sleep_max, activity_min, activity_max;

    public ExecutionThread(Integer monitor1, Integer monitor2, int sleep_min, int sleep_max, int activity_min, int activity_max){
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;

        this.sleep_min = sleep_min;
        this.sleep_max = sleep_max;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }



    public void run(){
        System.out.println(this.getName() + " - STATE 1");
        int k1 = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i < k1 * 100000; i++) {
            i++;
            i--;
        }
        synchronized (monitor1) {
            System.out.println(this.getName() + " - STATE 2");
            int k2= (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for (int i = 0; i < k2 * 100000; i++) {
                i++;
                i--;
            }

        }
            synchronized (monitor2) {
                System.out.println(this.getName() + " - STATE 3");
                int k2 = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                for (int i = 0; i < k2 * 100000; i++) {
                    i++;
                    i--;//no loop
                }
                try {
                    Thread.sleep(3 * 500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        System.out.println(this.getName() + " - STATE 4");

    }
}
