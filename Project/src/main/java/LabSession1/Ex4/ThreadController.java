package LabSession1.Ex4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThreadController {
    Fir f;
    Window w;

    public ThreadController(Fir f, Window w){
        f.addObserver(w);
        this.f = f;
        this.w = w;
    }

}