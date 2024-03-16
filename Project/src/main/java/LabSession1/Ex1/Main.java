package LabSession1.Ex1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Calculator MyCalculator = new Calculator();

        Calculator.ShowMenu();
        int Operation = MyCalculator.getOption();
        ComplexNb MyNymbers[] = Calculator.getNumbers();
        ComplexNb Result = Calculator.Calculate(Operation,MyNymbers[0],MyNymbers[1]);
        System.out.println("The result is: ");
        Result.Display();

    }
}
