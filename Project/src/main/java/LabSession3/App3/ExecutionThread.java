package LabSession3.App3;

public class ExecutionThread extends Thread{
    Integer monitor;



    int sleep_min, sleep_max, activity_min, activity_max;

    public ExecutionThread(Integer monitor1, int sleep_min, int sleep_max, int activity_min, int activity_max){
        this.monitor = monitor1;


        this.sleep_min = sleep_min;
        this.sleep_max = sleep_max;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }



    public void run(){
        while(true){
            System.out.println(this.getName() + " - STATE 1");
            synchronized (monitor) {
                System.out.println(this.getName() + " - STATE 2");
                int k1 = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                for (int i = 0; i < k1 * 100000; i++) {
                    i++;
                    i--;
                }
            }
            try {
                Thread.sleep(3 * 500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(this.getName() + " - STATE 3");

            System.out.println(this.getName() + " - STATE 4");

        }
    }
}
