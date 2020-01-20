package com.vnaidu;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class BarrenLandAnaysis {
    private static final int TOTAL_HEIGHT = 18000;
    private static final int TOTAL_WIDTH = 12000;

    private static String[] input1 = {"48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547"};

    private static Land[][] matrix = new Land[TOTAL_WIDTH][TOTAL_HEIGHT];

    private static List<List<Integer>> listOfBarrenCoords = new ArrayList<>();

    /**
     * Populate the initial matrix as unchecked and fertile.
     * @param matrix the matrix to populate
     */
    private static void buildMatrix(Land[][] matrix) {
        for (int x = 0; x < TOTAL_WIDTH; x++) {
            for (int y = 0; y < TOTAL_HEIGHT; y++) {
                matrix[x][y] = new Land(x, y, 0, true);
            }
        }
    }

    /**
     * Convert the array of coordinate strings into a list of list of integers
     * @param input Array of string where each string has 2 pairs of coordinates that are separated by spaces.
     */
    private static void stringsToListOfLists(String[] input) {

        for (String s : input) {
            String[] split = s.split(" ");

            List<Integer> coords = Arrays.asList(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));// turns coords from string into array

            listOfBarrenCoords.add(coords);
        }
    }
    /**
     * Mark the points in between each pair of coordinates given as input as visited and infertile.
     * @param input The array of input coordinates that need to be marked as infertile.
     */
    static void mapBarrenLandToField(String[] input) {
        stringsToListOfLists(input);

        listOfBarrenCoords.forEach(coords -> {
            for (int x = coords.get(0); x < coords.get(2)+1; x++) {
                for (int y = coords.get(1); y < coords.get(3) + 1; y++) {
                    matrix[x][y].setFertile(false); // makes each point within the coordinates marked as infertile
                }
            }
        });
    }

    static void fillInArea2(int coordX, int coordY, int count) {
        int x = coordX;
        int y = coordY;
        Deque<Land> queue = new ArrayDeque<>();                          // the queue stores the list of points that still need to be checked
        queue.push(matrix[x][y]);                                   // the seed point is the first item in the queue
        while (!queue.isEmpty()) {                                     // as long as there are points in the queue to be checked...
            Land fieldxy = queue.pop();                              // remove the last element from the queue and store it in variable fieldxy
            fieldxy.setChecked(count);                              // mark the point as a part of the current area by assigning it the current area count value
            x = fieldxy.getX();                                     // set variables x and y to the coordinates of the current point being checked
            y = fieldxy.getY();

            // these conditionals check points on all 4 sides of fieldxy
            // if they are fertile and unchecked (as indicated by 0), then it adds them to the queue to be checked later
            if (x + 1 != TOTAL_WIDTH &&matrix[x + 1][y].getChecked() == 0 && matrix[x + 1][y].getFertile()) { // right
                queue.push(matrix[x + 1][y]);
            }
            if (x - 1 != -1 && matrix[x - 1][y].getChecked() == 0 && matrix[x - 1][y].getFertile()) { // left
                queue.push(matrix[x - 1][y]);
            }
            if (y + 1 != TOTAL_HEIGHT && matrix[x][y + 1].getChecked() == 0 && matrix[x][y + 1].getFertile()) { // above
                queue.push(matrix[x][y + 1]);
            }
            if (y - 1 != -1 && matrix[x][y - 1].getChecked() == 0 && matrix[x][y - 1].getFertile()) { // below
                queue.push(matrix[x][y - 1]);
            }
        }
    }

    static List<Integer> processInput(String[] input) {
        mapBarrenLandToField(input);                                        // maps the barren areas onto the 400x600 matrix of the total land
        List<Integer> uoListOfOutputs = new ArrayList<>();                                                       // to collect the list of unordered outputs
        int fertileAreaCount = 1;                                                       // used to distinguish between distinct fertile areas
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {                                 // maps through the entire matrix of the field with barren land
                if (matrix[x][y].getFertile() && matrix[x][y].getChecked() == 0) {        // once it hits a fertile point (not yet checked as indicated by the {checked: 0})
                    fillInArea2(x, y, fertileAreaCount);                                     // it runs the BFS algorithm and returns the field containing the found fertile area which now has "checked" assigned to the area's value
                    uoListOfOutputs.add(totalArea(fertileAreaCount));    // totalArea calculates the area where "checked" is equal to the area value. This value gets pushed into the unordered list of outputs
                    // console.log(fertileAreaCount)
                    fertileAreaCount++;                                                 // finally the fertile area count is incremented so that the next area to be found has a unique area value
                }
            }
        }
        uoListOfOutputs.sort(Comparator.naturalOrder());
        return uoListOfOutputs;
    }

    // takes in a matrix of the field a condition and returns the total area (in meters) of land that fits the condition
    private static int totalArea(int condition) {
        int area = 0;
        for (Land[] lands : matrix) {
            for (Land land : lands) {
                if (land.getChecked() == condition) {
                    area++;
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        buildMatrix(matrix);
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the coordinates for the bottom left corner and the top right corner of a rectangle\nThe coordinates need to be added in the following format: x1 y1 x2 y2 with single spaces separating the numbers");
        String line = scan.nextLine();
        List<String> inputs = new ArrayList<>();
        while(!line.isEmpty()) {
            inputs.add(line);
            System.out.println("Enter the coordinates for the bottom left corner and the top right corner of a rectangle or an empty line if no more inputs are needed.");

            line = scan.nextLine();
        }
        BarrenLandAnaysis.input1 = inputs.toArray(new String[0]);
        StopWatch timer = new StopWatch();
        timer.start();
        System.out.println(processInput(BarrenLandAnaysis.input1).toString());
        timer.stop();
        System.out.println("Time Elapsed: " + timer.getTime());
    }
}
