package LabSession3.App4;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Integer monitor1 = new Integer(1);
        Integer monitor2 = new Integer(2);
        Notifier notifier = new Notifier(monitor1,monitor2, 2, 4, 3, 6);

        Thread t3 =  new Thread(notifier,"Notifier");

        Waiter waiter1 = new Waiter(monitor1, t3,3, 5, 4, 7);
        Waiter waiter2 = new Waiter(monitor2, t3,4, 6, 4, 7);

        Thread t1 =  new Thread(waiter1,"Waiter1");
        Thread t2 =  new Thread(waiter2,"Waiter2");

        t3.start();
        t1.start();
        t2.start();

       // modify the constructors for the waiter class to pass an attribute which is the thread of the notifier

    }
}