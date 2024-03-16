package LabSession1.Ex4;

import java.util.Observable;

public class Fir extends Observable implements Runnable {

    int id;

    Window win;

    Thread t;

    int processorLoad;

    int c;

    Fir(int id, int priority,Window win, int procLoad) {

        this.id = id;

        this.win = win;

        this.processorLoad = procLoad;

        this.t = new Thread();
        this.t.setPriority(priority);

    }

    public void run() {

        c = 0;

        while (c < 1000) {

            for (int j = 0; j < this.processorLoad; j++) {

                j++;

            }
            c++;
            this.setChanged();
            this.notifyObservers();
        }
    }

    public void start() {
            this.t = new Thread(this);
            new ThreadController(this,this.win);
            this.t.start();
    }

    public int getC() {
        return this.c;
    }

    public int getID() {
        return this.id;
    }

    public Window getWin(){
        return this.win;
    }
}