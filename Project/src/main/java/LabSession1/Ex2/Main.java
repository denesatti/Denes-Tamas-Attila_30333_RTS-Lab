package LabSession1.Ex2;

public class Main {
    public static void main(String[] args) {
        int[][] M1 = {{2, 3, 1},
                {7, 1, 6},
                {9, 2, 4}};

        int[][] M2 = {{8, 5, 3},
                {3, 9, 2},
                {2, 7, 3}};

        int[][] Result = new int[3][3];

        //Sum of matrices
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Result[i][j] = M1[i][j] + M2[i][j];
            }
        }

        System.out.println("The sum of matrices M1 and M2 is:");
        for (int i = 0; i < 3; i++) {
            System.out.println(String.valueOf(Result[i][0]) + " " + String.valueOf(Result[i][1]) + " " + String.valueOf(Result[i][2]));
            System.out.println("\n");
        }

        // Reseting the Result matrice
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Result[i][j] = 0;
            }
        }

        //Product of matrices
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
               for(int k = 0; k < 3; k++){
                   Result[i][j] += M1[i][k]*M2[k][j];
               }
            }
        }

        System.out.println("The produs of matrices M1 and M2 is:");
        for (int i = 0; i < 3; i++) {
            System.out.println(String.valueOf(Result[i][0]) + " " + String.valueOf(Result[i][1]) + " " + String.valueOf(Result[i][2]));
            System.out.println("\n");
        }

    }
}
