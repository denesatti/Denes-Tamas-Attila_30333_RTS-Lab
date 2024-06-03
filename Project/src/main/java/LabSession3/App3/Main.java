package LabSession3.App3;

public class Main {
    public static void main(String[] args) {
        Integer monitor1 = new Integer(1);
        new ExecutionThread(monitor1, 2, 4, 3, 6).start();
        new ExecutionThread(monitor1, 3, 5, 4, 7).start();
        new ExecutionThread(monitor1, 4, 6, 5, 8).start();
    }
}