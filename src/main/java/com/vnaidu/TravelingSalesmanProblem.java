package com.vnaidu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TravelingSalesmanProblem {

    public static int tsp(int[][] distanceMatrix) {
        int numberOfCities = distanceMatrix.length;
        boolean[] visited = new boolean[numberOfCities];
        Arrays.fill(visited, false);

        visited[0] = true;
        int currentCity = 0;
        int nextCity;
        int minDistance;
        int totalDistance = 0;

        List<Integer> path = new ArrayList<>();
        path.add(0); // Start at the first city

        for (int i = 0; i < numberOfCities - 1; i++) {
            minDistance = Integer.MAX_VALUE;
            nextCity = -1;

            for (int j = 0; j < numberOfCities; j++) {
                if (!visited[j] && distanceMatrix[currentCity][j] < minDistance) {
                    minDistance = distanceMatrix[currentCity][j];
                    nextCity = j;
                }
            }

            visited[nextCity] = true;
            path.add(nextCity);
            totalDistance += minDistance;
            currentCity = nextCity;
        }

        // Return to the starting city
        path.add(0);
        totalDistance += distanceMatrix[currentCity][0];

        System.out.println("Path: " + path);

        return totalDistance;
    }

    public static void main(String[] args) {
        int[][] distanceMatrix = {
                {0, 2, 9, 10},
                {1, 0, 6, 4},
                {15, 7, 0, 8},
                {6, 3, 12, 0}
        };

        int shortestDistance = tsp(distanceMatrix);
        System.out.println("Shortest Distance: " + shortestDistance);
    }
}
