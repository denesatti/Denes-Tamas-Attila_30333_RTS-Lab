package LabSession3.App1;

public class Main {
    public static void main(String[] args) {
        Integer monitor1 = new Integer(1);
        Integer monitor2 = new Integer(1);
        new ExecutionThread(monitor1, 2, 4, 3, 6).start();
        new ExecutionThread(monitor1,monitor2, 3, 5, 4, 7).start();
        new ExecutionThread(monitor2, 4, 5, 5, 8).start();
    }
}