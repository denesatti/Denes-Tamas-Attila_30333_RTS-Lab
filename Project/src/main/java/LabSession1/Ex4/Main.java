package LabSession1.Ex4;


// This exercise is from LabSheet2, App2
public class Main {

    private static final int noOfThreads=6;

    private static final int processorLoad=10000000;


    public static void main(String args[]){

        Window win=new Window(noOfThreads);

        for(int i =0; i<noOfThreads; i++){

            new Fir(i,i+2,win,processorLoad).start();

        }

    }

}