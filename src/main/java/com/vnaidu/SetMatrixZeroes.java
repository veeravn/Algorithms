package com.vnaidu;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0)
            return;
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        int[] row = new int[rowLength];  // array to store those rows whose elements 'll changed to 0
        int[] col = new int[colLength];   //arrays to store those columns which'll be changed to 0

        for (int i = 0; i < rowLength; i++) {       //finding those rows and cloumns to be chnged to 0
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;                 // 1 is stored at index of rows array which contains 0 in the matrix
                    col[j] = 1;                // 1 is stored at index of col array which contains 0 in the matrix
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (row[i] == 1 || col[j] == 1) {        //if any row no. or col no. contains 1 then the the whole column
                    matrix[i][j] = 0;                   // or row will be changed
                }
            }
        }
    }
}
