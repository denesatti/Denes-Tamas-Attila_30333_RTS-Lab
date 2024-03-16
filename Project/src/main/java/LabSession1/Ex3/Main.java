package LabSession1.Ex3;
import java.lang.Math;
import java.sql.Array;
import java.util.Arrays;


public class Main {
    public static void main(String[] args)  {
        int NbOfNb = 10;

        double RandomNumbers[] = new double[NbOfNb];

        for(int i = 0; i < NbOfNb; i++){
            RandomNumbers[i] = Math.random();
        }
        Arrays.sort(RandomNumbers);

        System.out.println("The sorted array:");
        for(int i = 0; i < NbOfNb; i++){
            System.out.println(RandomNumbers[i]);
        }

    }
}
