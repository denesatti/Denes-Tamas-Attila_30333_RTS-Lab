package LabSession1.Ex1;

public class ComplexNb {
    float real = 0;
    float img  = 0;

    public void Display(){
        System.out.println(this.real + " " + this.img + "i");
    }

    public ComplexNb(float real, float img){
        this.real = real;
        this.img  = img;
    }
    public ComplexNb(){
        this.real = 0;
        this.img  = 0;
    }
}
