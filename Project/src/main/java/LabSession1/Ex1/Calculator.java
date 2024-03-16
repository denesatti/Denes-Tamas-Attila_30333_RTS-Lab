package LabSession1.Ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    static void ShowMenu(){
        System.out.println("Hi, this is a simple calculator for complex numbers.");
        System.out.println("Please select the operation:");
        System.out.println("1: +");
        System.out.println("2: -");
        System.out.println("3: *\n");
    }

    static int getOption() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer option = Integer.valueOf(reader.readLine());
        return option;
    }

    static ComplexNb[] getNumbers() throws IOException {
        System.out.println("Please input the first complex number you want to do the caclulation with.");
        System.out.println("(In:a bi format)");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String InitialInput = reader.readLine();
        String SplitInit[] = InitialInput.split("i");
        String Split[] = SplitInit[0].split("\\s+");

        float real = Float.valueOf(Split[0]);
        float img = Float.valueOf(Split[1]);

        ComplexNb Nb1 = new ComplexNb(real, img);

        System.out.println("Please input the second complex number you want to do the caclulation with.");
        System.out.println("(In:a bi format)");

        InitialInput = reader.readLine();
        SplitInit = InitialInput.split("i");
        Split = SplitInit[0].split("\\s+");

        real = Float.valueOf(Split[0]);
        img = Float.valueOf(Split[1]);

        ComplexNb Nb2 = new ComplexNb(real, img);

        ComplexNb Numbers[] = {Nb1, Nb2};

        return Numbers;
    }

    static ComplexNb Calculate(int operation, ComplexNb Nb1,ComplexNb Nb2){
        ComplexNb result = new ComplexNb();
        switch(operation) {
            case 1:
                result.real = Nb1.real + Nb2.real;
                result.img  = Nb1.img  + Nb2.img;
                break;
            case 2:
                result.real = Nb1.real - Nb2.real;
                result.img  = Nb1.img  - Nb2.img;
                break;
            case 3:
                result.real = Nb1.real*Nb2.real - Nb1.img*Nb2.img;
                result.img  = Nb1.real*Nb2.img - Nb1.img*Nb2.real;
                break;
        }
        return  result;
    }

}
