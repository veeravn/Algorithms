package com.vnaidu;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        //create arrays to hold the bitmasks for the seen numbers for rows, columns, and sub-boxes
        // bitwise operations will be used to quickly check and set bits.
        int[] rows = new int[9];
        int[] columns = new int[9];
        int[] boxes = new int[9];

        //Traverse the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //skip if the board at i,j doesn't have a number
                if (board[i][j] == '.') continue;

                int num = board[i][j] - '1'; // Convert '1'-'9' to 0-8
                int bitMask = 1 << num;         // Create bitmask for the number
                //find the sub-box that the square i,j belongs to
                int boxIndex = (i / 3) * 3 + j / 3;

                // Check if the number is already set in the row, column, or box
                if ((rows[i] & bitMask) != 0 || (columns[j] & bitMask) != 0 || (boxes[boxIndex] & bitMask) != 0) {
                    return false;
                }

                // Mark the number in the row, column, and box
                rows[i] |= bitMask;
                columns[j] |= bitMask;
                boxes[boxIndex] |= bitMask;
            }
        }
        return true;
    }
}
