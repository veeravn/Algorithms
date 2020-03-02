package com.vnaidu;

/*
Imagine we have an image. We'll represent this image as a simple 2D array where every pixel is a 1 or a 0.

The image you get is known to have potentially many distinct rectangles of 0s on a background of 1s. Write a function that takes in the image and returns the coordinates of all the 0 rectangles -- top-left and bottom-right; or top-left, width and height.

image1 = [
[0, 1, 1, 1, 1, 1, 1],
[1, 1, 1, 1, 1, 1, 1],
[0, 1, 1, 0, 0, 0, 1],
[1, 0, 1, 0, 0, 0, 1],
[1, 0, 1, 1, 1, 1, 1],
[1, 0, 1, 0, 0, 1, 1],
[1, 1, 1, 0, 0, 1, 1],
[1, 1, 1, 1, 1, 1, 0],
]

Sample output variations (only one is necessary):

findRectangles(image1) =>
// (using top-left-row-column and bottom-right):
[
[[0,0],[0,0]],
[[2,0],[2,0]],
[[2,3],[3,5]],
[[3,1],[5,1]],
[[5,3],[6,4]],
[[7,6],[7,6]],
]
// (using top-left-x-y and width/height):
[
[[0,0],[1,1]],
[[0,2],[1,1]],
[[3,2],[3,2]],
[[1,3],[1,3]],
[[3,5],[2,2]],
[[6,7],[1,1]],
]

Other test cases:

image2 = [
[0],
]

findRectangles(image2) =>
// (using top-left-row-column and bottom-right):
[
[[0,0],[0,0]],
]

// (using top-left-x-y and width/height):
[
[[0,0],[1,1]],
]

image3 = [
[1],
]

findRectangles(image3) => []

image4 = [
[1, 1, 1, 1, 1],
[1, 0, 0, 0, 1],
[1, 0, 0, 0, 1],
[1, 0, 0, 0, 1],
[1, 1, 1, 1, 1],
]

findRectangles(image4) =>
// (using top-left-row-column and bottom-right or top-left-x-y and width/height):
[
[[1,1],[3,3]],
]

n: number of rows in the input image
m: number of columns in the input image
*/

import java.util.ArrayList;
import java.util.List;

public class FindRectangle {

    public static void main(String[] argv) {
        int[][] image1 = {
                {0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 0},
        };

        int[][] image2 = {
                {0},
        };

        int[][] image3 = {
                {1},
        };

        int[][] image4 = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1},
        };

        System.out.println(findRectangle(image1));
        System.out.println(findRectangle(image2));
        System.out.println(findRectangle(image3));
        System.out.println(findRectangle(image4));

    }

    public static String findRectangle(int[][] image) {

        int rows = image.length;
        int columns = image[0].length;
        List<String> outList = new ArrayList<>();
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < columns; col++) {
                int curWidth = 0;
                int curLength = 0;
                int curRectRow;
                int curRectCol;
                if (image[row][col] == 0) {
                    curRectRow = row;
                    curRectCol = col;
                    for (int i = col; i < columns; i++) {

                        if (image[row][i] == 1) {
                            break;
                        } else {
                            curWidth++;
                        }
                    }
                    for (int i = row; i < rows; i++) {
                        if (image[i][col] == 1) {
                            break;
                        } else {
                            curLength++;
                        }
                    }
                    col += curWidth - 1;
                    row += curLength - 1;
                    StringBuilder curRecOutput = new StringBuilder();
                    curRecOutput.append("[")
                            .append(curRectRow).append(",")
                            .append(curRectCol)
                            .append("]").append("[")
                            .append(curWidth).append(",")
                            .append(curLength).append("]");

                    outList.add(curRecOutput.toString());
                }
            }
        }
        return outList.toString();
    }
}
